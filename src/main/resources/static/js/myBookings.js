// Utility function to get query parameters (if needed)
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

// Fetch bookings for the logged-in user
async function fetchMyBookings() {
    const token = localStorage.getItem("token");
    console.log("Token:", token);
    try {
        const response = await fetch("http://localhost:8080/api/bookings", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`
            }
        });
        console.log("Response status:", response.status);
        if (response.ok) {
            const text = await response.text();
            let bookings;
            if (text.length === 0) {
                bookings = [];
            } else {
                bookings = JSON.parse(text);
            }
            displayBookings(bookings);
        } else {
            document.getElementById("bookings-container").textContent = "Error loading bookings.";
            console.error("Failed to load bookings:", response.status);
        }
    } catch (error) {
        console.error("Error fetching bookings:", error);
        document.getElementById("bookings-container").textContent = "Error loading bookings.";
    }
}

function displayBookings(bookings) {
    const container = document.getElementById("bookings-container");
    container.innerHTML = "";

    if (!bookings.length) {
        container.textContent = "You have no bookings.";
        return;
    }

    bookings.forEach(booking => {
        const bookingCard = document.createElement("div");
        bookingCard.classList.add("booking-card");

        const hotelName = booking.hotel && booking.hotel.name ? booking.hotel.name : "N/A";
        const status = booking.status && booking.status.statusName ? booking.status.statusName : "unknown";

        bookingCard.innerHTML = `
      <p>Hotel: ${hotelName}</p>
      <p>Check-In: ${booking.checkIn}</p>
      <p>Check-Out: ${booking.checkOut}</p>
      <p>Status: ${status}</p>
      <p>Amount: $${booking.price || "N/A"}</p>
    `;

        // Pay Now button for pending
        if (status.toLowerCase() === "pending") {
            const payButton = document.createElement("a");
            payButton.textContent = "Pay Now";
            payButton.href = `/choose-payment?bookingId=${booking.bookingId}&roomId=${booking.room?.id || ""}&amount=${booking.price}`;
            payButton.classList.add("pay-button");
            bookingCard.appendChild(payButton);

            // Cancel button
            const cancelButton = document.createElement("button");
            cancelButton.textContent = "Cancel Booking";
            cancelButton.classList.add("cancel-button");
            cancelButton.addEventListener("click", async () => {
                if (!confirm("Are you sure you want to cancel this booking?")) return;
                try {
                    const token = localStorage.getItem("token");
                    const response = await fetch(`http://localhost:8080/api/bookings/cancel/${booking.bookingId}`, {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json",
                            "Authorization": token ? `Bearer ${token}` : ""
                        }
                    });
                    if (response.ok) {
                        alert("Booking cancelled successfully.");
                        // Refresh the bookings list
                        fetchMyBookings();
                    } else {
                        const err = await response.text();
                        alert("Cancellation failed: " + err);
                    }
                } catch (err) {
                    console.error("Error cancelling booking:", err);
                    alert("An error occurred while cancelling. Please try again.");
                }
            });
            bookingCard.appendChild(cancelButton);
        }

        if (status.toLowerCase() === "confirmed") {
            const bookAgainBtn = document.createElement("button");
            bookAgainBtn.textContent = "Book Again";
            bookAgainBtn.classList.add("again-button");
            bookAgainBtn.addEventListener("click", () => {
                // Redirect to booking page, passing the room's ID
                // You can use booking.room.id or booking.roomId (if you add that to the DTO)
                window.location.href = `/hotel-rooms?hotelId=${booking.hotelId}`;
            });
            bookingCard.appendChild(bookAgainBtn);
        }


        container.appendChild(bookingCard);
    });
}


document.addEventListener("DOMContentLoaded", fetchMyBookings);
