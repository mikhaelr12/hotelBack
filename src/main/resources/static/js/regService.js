document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("registerForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent default form submission

        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const phoneNumber = document.getElementById("phoneNumber").value;

        const data = { username, email, password, phoneNumber};

        fetch("/api/auth/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => response.text())
            .then(message => {
                alert(message);
                window.location.href = "/login";
            })
            .catch(error => {
                console.error("Error:", error);
                alert(error.message || "Registration failed");
            });

    });
});