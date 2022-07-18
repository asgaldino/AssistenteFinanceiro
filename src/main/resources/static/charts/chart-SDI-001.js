let installments = document.getElementsByClassName("vInstallments");
    let details = document.getElementById('details');
    let income = parseInt(details.firstElementChild.textContent);
    let vInstallments =[];

    for (const item of installments) {
        vInstallments.push(parseInt(item.innerHTML));
    }    
    let committed = vInstallments.reduce(function(accumulator, value){
        return accumulator + value;
    })
    let livre = parseInt((committed * 100 ) / income);

    let divcommitted = document.getElementById('committed');
    divcommitted.innerHTML = ('Comprometido: ' +livre+"%");