// Utility function to get query parameters from the URL
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

// Extract the booking parameters from the URL (bookingId, roomId, amount)
const params = getQueryParams();
const bookingId = params.bookingId;
const roomId = params.roomId;
const amount = params.amount;

// Display booking information to the user
const bookingInfoDiv = document.getElementById("booking-info");
bookingInfoDiv.innerHTML = `
  <p><strong>Booking ID:</strong> ${bookingId}</p>
  <p><strong>Amount:</strong> $${amount}</p>
`;

// Redirect to the appropriate payment page when a button is clicked
document.getElementById("stripeBtn").addEventListener("click", function () {
    window.location.href = `/stripe?bookingId=${bookingId}&roomId=${roomId}&amount=${amount}`;
});

document.getElementById("paypalBtn").addEventListener("click", function () {
    window.location.href = `/paypal?bookingId=${bookingId}&roomId=${roomId}&amount=${amount}`;
});
