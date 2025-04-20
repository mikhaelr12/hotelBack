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

const params = getQueryParams();
const bookingId = params.bookingId;
const roomId = params.roomId;
const amount = params.amount;

const bookingInfoDiv = document.getElementById("booking-info");
bookingInfoDiv.innerHTML = `
  <p><strong>Booking ID:</strong> ${bookingId}</p>
  <p><strong>Amount:</strong> $${amount}</p>
`;

function renderPayPalButtons() {
    if (typeof paypal === 'undefined') {
        setTimeout(renderPayPalButtons, 100);
        return;
    }

    paypal.Buttons({
        createOrder: function(data, actions) {
            return actions.order.create({
                purchase_units: [{
                    amount: {
                        value: amount
                    }
                }]
            });
        },
        onApprove: function(data, actions) {
            return actions.order.capture().then(function(details) {
                const paymentRequest = {
                    bookingId: parseInt(bookingId),
                    amount: parseFloat(amount),
                    source: details.id
                };

                fetch("http://localhost:8080/api/payments/paypal", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(paymentRequest)
                })
                    .then(response => {
                        if (response.ok) {
                            alert("Payment successful!");
                            window.location.href = '/index';
                        } else {
                            return response.text().then(text => { throw new Error(text) });
                        }
                    })
                    .catch(err => {
                        console.error("Error during payment processing:", err);
                        alert("Payment failed: " + err.message);
                    });
            });
        },
        onError: function(err) {
            console.error("PayPal error:", err);
            alert("An error occurred with PayPal. Please try again later.");
        }
    }).render('#paypal-button-container');
}

renderPayPalButtons();
