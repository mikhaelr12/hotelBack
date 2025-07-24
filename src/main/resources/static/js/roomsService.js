// Utility function to get query parameters from URL
function getQueryParams() {
    const params = {};
    window.location.search.substring(1).split("&").forEach(pair => {
        const [key, value] = pair.split("=");
        if (key) {
            params[key] = decodeURIComponent(value);
        }
    });
    return params;
}

async function fetchRoomsForHotel() {
    const params = getQueryParams();
    const hotelId = params.hotelId; // e.g., rooms?hotelId=1

    if (!hotelId) {
        document.getElementById("rooms-container").textContent = "No hotel selected.";
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/rooms/${hotelId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            const rooms = await response.json();
            displayRooms(rooms);
        } else {
            document.getElementById("rooms-container").textContent = "No rooms found for this hotel.";
        }
    } catch (error) {
        console.error("Error fetching rooms: ", error);
        document.getElementById("rooms-container").textContent = "Error loading rooms.";
    }
}

function displayRooms(rooms) {
    const container = document.getElementById("rooms-container");
    container.innerHTML = "";

    if (rooms.length === 0) {
        container.textContent = "No rooms available.";
        return;
    }

    rooms.forEach(room => {
        // Create a container for each room
        const roomElement = document.createElement("div");
        roomElement.classList.add("room");

        // Room image
        const roomImage = document.createElement("img");
        roomImage.src = room.image; // Ensure your room object has an image property
        roomImage.alt = room.name;
        roomElement.appendChild(roomImage);

        // Room name
        const roomName = document.createElement("h3");
        roomName.textContent = room.name;
        roomElement.appendChild(roomName);

        // Room description
        const roomDescription = document.createElement("p");
        roomDescription.textContent = room.description || "No description available.";
        roomElement.appendChild(roomDescription);

        // Room price (optional)
        if (room.price) {
            const roomPrice = document.createElement("span");
            roomPrice.classList.add("price");
            roomPrice.textContent = `$${room.price} / night`;
            roomElement.appendChild(roomPrice);
        }

        // Optional: Book button
        const bookButton = document.createElement("a");
        bookButton.textContent = "Book Now";
        bookButton.href = `/booking?roomId=${room.id}`;
        bookButton.classList.add("view-button");
        roomElement.appendChild(bookButton);

        container.appendChild(roomElement);
    });
}

// Load rooms when the page is ready
document.addEventListener('DOMContentLoaded', fetchRoomsForHotel);
