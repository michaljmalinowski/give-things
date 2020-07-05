const categories = document.querySelectorAll("div[data-step='1'] label");
for (let i = 0; i < categories.length; i++) {
    if (categories[i].querySelector("input").checked) {
        console.log(categories[i].querySelector(".description").innerText);
    }
}