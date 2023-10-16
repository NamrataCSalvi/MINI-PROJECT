document.addEventListener("DOMContentLoaded", function () {
    const imageInput = document.getElementById("imageInput");
    const imageGrid = document.getElementById("imageGrid");
    const statusLabel = document.getElementById("statusLabel");
    const confirmButton = document.getElementById("confirmButton");
    const passwordDisplay = document.getElementById("passwordDisplay");
    const selectedPassword = [];

    imageInput.addEventListener("change", function (e) {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (event) {
                const img = new Image();
                img.src = event.target.result;
                img.onload = function () {
                    createImageGrid(img);
                };
            };
            reader.readAsDataURL(file);
        }
    });

    function createImageGrid(image) {
        const parts = 9; // Number of grid parts
        const partWidth = image.width / 3;
        const partHeight = image.height / 3;

        for (let row = 0; row < 3; row++) {
            for (let col = 0; col < 3; col++) {
                const canvas = document.createElement("canvas");
                canvas.width = partWidth;
                canvas.height = partHeight;
                const context = canvas.getContext("2d");
                context.drawImage(
                    image,
                    col * partWidth,
                    row * partHeight,
                    partWidth,
                    partHeight,
                    0,
                    0,
                    partWidth,
                    partHeight
                );
                const imageDiv = document.createElement("div");
                imageDiv.classList.add("grid-item");
                imageDiv.appendChild(canvas);
                imageDiv.addEventListener("click", function () {
                    toggleSelected(imageDiv, row, col);
                });
                imageGrid.appendChild(imageDiv);
            }
        }
    }

    function toggleSelected(imageDiv, row, col) {
        if (selectedPassword.length < 3 || imageDiv.classList.contains("selected")) {
            if (imageDiv.classList.contains("selected")) {
                // Deselect
                imageDiv.classList.remove("selected");
                const index = selectedPassword.findIndex(item => item.row === row && item.col === col);
                if (index !== -1) {
                    selectedPassword.splice(index, 1);
                }
            } else {
                // Select
                imageDiv.classList.add("selected");
                selectedPassword.push({ row, col });
            }
            checkPassword();
        }
    }

    function checkPassword() {
        if (selectedPassword.length >= 3) {
            statusLabel.textContent = "Password selected successfully.";
            confirmButton.classList.remove("hidden");
        } else {
            statusLabel.textContent = "Select at least 3 image boxes as your password.";
            confirmButton.classList.add("hidden");
        }
    }

    confirmButton.addEventListener("click", function () {
        displayPassword();
    });

    function displayPassword() {
        const password = selectedPassword.map(item => `(${item.row + 1},${item.col + 1})`).join(" ");
        passwordDisplay.textContent = `Your selected password: ${password}`;
        passwordDisplay.classList.remove("hidden");
    }
    confirmButton.addEventListener("click", function () {
        displayPassword();
        // Change the button color when clicked (same code as before)
        confirmButton.style.backgroundColor = "#ff9900";
        setTimeout(() => {
            confirmButton.style.backgroundColor = "#007bff";
        }, 500);
    
        // Scroll to display the password
        passwordDisplay.scrollIntoView({
            behavior: "smooth", // Scroll behavior with animation
            block: "start",    // Scroll to the top of the passwordDisplay element
            inline: "nearest"  // Scroll to the nearest edge of the passwordDisplay element
        });
    });
    
    
});
