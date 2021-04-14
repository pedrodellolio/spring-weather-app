function changeBackground(dayTime) {
	var main = document.querySelector(".container");

	if (dayTime.charAt(2) == "d") {
		main.style.backgroundImage = "linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.0)), url('../images/kumiko-shimizu-lNxMcE8mvIM-unsplash.jpg')";


	} else {
		main.style.backgroundImage = "linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url('../images/jackson-hendry-eodA_8CTOFo-unsplash.jpg')";

	}
}

