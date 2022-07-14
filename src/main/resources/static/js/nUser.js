//Coleta os elementos
const userForm = async () => {
    const nameForm = document.getElementById('name')
    const emailForm = document.getElementById('email')
    const incomeForm = document.getElementById('income')
    const newPasswordForm = document.getElementById('newPassword')
    const confirmPasswordForm = document.getElementById('confirmPassword')  

    const user = {
        name: nameForm.value,
        email: emailForm.value,
        income: incomeForm.value,
        newPassword: newPasswordForm.value,
        confirmPassword: confirmPasswordForm.value
    }
    //console.log(user)

    const init = {
        method: 'POST',
        headers: {
            "Content-Type": 'application/json'
        },
        body: JSON.stringify(user)
    }
    //Inicia o post na api
    const response = await fetch('http://localhost:8080/api/user/add', init)
    const dados = await response.json()
    console.log(dados)

}



function teste(){
    userForm()


    console.log('FIM')
}
function onSubmit(){
    postData()
    userForm()
}
async function postData () {
    const nameForm = document.getElementById('name')
    const emailForm = document.getElementById('email')
    const incomeForm = document.getElementById('income')
    const newPasswordForm = document.getElementById('newPassword')
    const confirmPasswordForm = document.getElementById('confirmPassword')

    const userF = {
        name: nameForm.value,
        email: emailForm.value,
        income: incomeForm.value,
        newPassword: newPasswordForm.value,
        confirmPassword: confirmPasswordForm.value
    }

    let user = {
        name: userF.name,
        email: userF.email,
        income: userF.income,
        newPassword: userF.newPassword,
        confirmPassword: userF.confirmPassword
    }

    try {
        const response = await axios.post("https://reqbin.com/echo/post/json", user)
        console.log("Request successful!")
    } catch (error) {
        if (error.response) {
            console.log(error.response.status)
        } else {
            console.log(error.message)
        }
    }
}