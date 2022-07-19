let installments = document.getElementsByClassName("vInstallments");
let details = document.getElementById("details");
let income = parseInt(details.firstElementChild.textContent);
let vInstallments = [];

for (const item of installments) {
  vInstallments.push(parseInt(item.innerHTML));
}
let committed = vInstallments.reduce(function (accumulator, value) {
  return accumulator + value;
});
let available = parseInt(income - committed);

let setAvailable = document.getElementById("available");
setAvailable.innerHTML = "R$ " +available+",00";

let percent = parseInt((committed * 100) / income);
let bar = document.getElementById("progress-bar");
bar.style.width = percent+'%'
bar.innerHTML = percent + "%"

if (percent <= 30){
    bar.style.background = "linear-gradient(to right, rgb(73, 200, 116) 0%, rgb(53, 180, 133) 100%)"
    setAvailable.style.background = "linear-gradient(to right, rgb(73, 200, 116) 0%, rgb(53, 180, 133) 100%)"
}
if (percent > 30 && percent <= 50){
    bar.style.background = "linear-gradient(to right, rgb(153, 225, 98) 0%, rgb(73, 200, 116) 100%)"
    setAvailable.style.background = "linear-gradient(to right, rgb(153, 225, 98) 0%, rgb(73, 200, 116) 100%)"
}
if (percent > 50 && percent <= 70){
    bar.style.background = "linear-gradient(to right, rgb(250, 166, 37) 0%, rgb(246, 216, 16) 100%)"
    setAvailable.style.background = "linear-gradient(to right, rgb(250, 166, 37) 0%, rgb(246, 216, 16) 100%)"
}
if (percent > 70 && percent < 100){
    bar.style.background = "linear-gradient(to right, rgb(249, 76, 76) 0%, rgb(247, 113, 70) 100%)"
    setAvailable.style.background = "linear-gradient(to right, rgb(249, 76, 76) 0%, rgb(247, 113, 70) 100%)"
}
if (percent >= 100){
    bar.style.backgroundColor = 'red'
    setAvailable.style.background = 'red'
}

