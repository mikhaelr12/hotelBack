async function fetchFeaturedHotels() {
    try {
        const response = await fetch('http://localhost:8080/api/hotels/main-page', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            const hotels = await response.json();
            displayFeaturedHotels(hotels);
        } else {
            console.error("Failed to load featured hotels:", response.status);
        }
    } catch (error) {
        console.error("Error fetching featured hotels: ", error);
    }
}

function displayFeaturedHotels(hotels) {
    const container = document.getElementById("featured-hotels-container");
    container.innerHTML = "";

    hotels.forEach(hotel => {
        const hotelElement = document.createElement("div");
        hotelElement.classList.add("hotel");

        const hotelImage = document.createElement("img");
        hotelImage.src = hotel.image;
        hotelImage.alt = hotel.name;
        hotelElement.appendChild(hotelImage);

        const hotelName = document.createElement("h2");
        hotelName.textContent = hotel.name;
        hotelElement.appendChild(hotelName);

        const hotelLocation = document.createElement("p");
        if (hotel.country && hotel.country.countryName && hotel.country.cityName) {
            hotelLocation.textContent = `${hotel.country.countryName}, ${hotel.country.cityName}`;
        } else {
            hotelLocation.textContent = "Location not available";
        }
        hotelElement.appendChild(hotelLocation);

        const viewRoomsButton = document.createElement("a");
        viewRoomsButton.textContent = "View Rooms";
        viewRoomsButton.href = `/hotel-rooms?hotelId=${hotel.id}`;
        viewRoomsButton.classList.add("view-button");
        hotelElement.appendChild(viewRoomsButton);

        container.appendChild(hotelElement);
    });
}

document.addEventListener('DOMContentLoaded', fetchFeaturedHotels);
