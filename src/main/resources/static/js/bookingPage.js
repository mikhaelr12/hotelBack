// Utility function to get query parameters from URL
function getQueryParams() {
    const params = {};
    window.location.search
        .substring(1)
        .split("&")
        .forEach(pair => {
            const [key, value] = pair.split("=");
            if (key) {
                params[key] = decodeURIComponent(value);
            }
        });
    return params;
}

// Fetch booked dates for a specific room
async function fetchBookedDates(roomId) {
    try {
        const response = await fetch(`http://localhost:8080/api/rooms/bookings/${roomId}`, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
        });
        if (response.ok) {
            const bookings = await response.json();
            displayBookedDates(bookings);
            return bookings;
        } else {
            document.getElementById("bookedDatesInfo").textContent =
                "No bookings found for this room.";
            return [];
        }
    } catch (error) {
        console.error("Error fetching bookings:", error);
        document.getElementById("bookedDatesInfo").textContent =
            "Error loading booked dates.";
        return [];
    }
}

function displayBookedDates(bookings) {
    const infoContainer = document.getElementById("bookedDatesInfo");
    infoContainer.innerHTML = "<h3>Booked Dates:</h3>";

    if (bookings.length === 0) {
        infoContainer.innerHTML += "<p>This room is currently available.</p>";
        return;
    }

    const list = document.createElement("ul");
    bookings.forEach(booking => {
        const listItem = document.createElement("li");
        listItem.textContent = `From ${booking.checkIn} to ${booking.checkOut}`;
        list.appendChild(listItem);
    });
    infoContainer.appendChild(list);
}

// Initialize Flatpickr with disabled ranges
async function initializeDatePickers(roomId) {
    const bookings = await fetchBookedDates(roomId);
    const disabledRanges = bookings.map(b => ({ from: b.checkIn, to: b.checkOut }));

    flatpickr("#checkIn", {
        dateFormat: "Y-m-d",
        disable: disabledRanges,
        onChange(selectedDates, dateStr) {
            flatpickr("#checkOut", {
                dateFormat: "Y-m-d",
                minDate: dateStr,
                disable: disabledRanges
            });
        }
    });

    flatpickr("#checkOut", {
        dateFormat: "Y-m-d",
        disable: disabledRanges
    });
}

// Handle booking form submission
async function handleBookingSubmit(event, roomId) {
    event.preventDefault();
    console.log("Submitting booking…");

    const checkIn = document.getElementById("checkIn").value;
    const checkOut = document.getElementById("checkOut").value;
    const notificationType = document.getElementById("notificationType").value;

    const bookingDTO = {
        checkIn,
        checkOut,
        roomId: Number(roomId),
        notificationType
    };

    const token = localStorage.getItem("token");

    try {
        const response = await fetch("http://localhost:8080/api/bookings", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": token ? `Bearer ${token}` : ""
            },
            body: JSON.stringify(bookingDTO)
        });

        console.log("Response status:", response.status);

        if (response.ok) {
            const { bookingId } = await response.json();
            alert("Booking successful! Confirmation ID: " + bookingId);
            window.location.href = "/my-bookings";
        } else {
            const errorText = await response.text();
            alert("Booking failed: " + errorText);
        }
    } catch (error) {
        console.error("Error during booking:", error);
        alert("An error occurred during booking. Please try again later.");
    }
}

// === ENTRY POINT ===
// Wait for DOM, then set up date pickers AND form listener
document.addEventListener("DOMContentLoaded", () => {
    const params = getQueryParams();
    const roomId = params.roomId;

    if (!roomId) {
        return alert("No room selected.");
    }

    // Initialize Flatpickr
    initializeDatePickers(roomId);

    // Wire up form submit
    const bookingForm = document.getElementById("bookingForm");
    bookingForm.addEventListener("submit", event =>
        handleBookingSubmit(event, roomId)
    );
});
