let saveFile = () => {
    // Get the data from each element on the form.
    const name = document.getElementById("txtName");
    
    const email = document.getElementById("txtEmail");
    const image = document.getElementById('imageInput');

    // This variable stores all the data.
    let data = "\r Name: " + name.value + " \r\n "  + "Email: " + email.value + " \r\n " + "Image" + image.value + "\r\n" ;
    console.log(data); //printing form data into the console
    // Convert the text to BLOB.
    const textToBLOB = new Blob([data], { type: "text/plain" });
    
    let newLink = document.createElement("a");
    newLink.download = new Date();

    if (window.webkitURL != null) {
        newLink.href = window.webkitURL.createObjectURL(textToBLOB);
    } else {
        newLink.href = window.URL.createObjectURL(textToBLOB);
        newLink.style.display = "none";
        document.body.appendChild(newLink);
    }

    newLink.click();
};