function check_username() {
    const username_error = document.getElementById("username_error");
    const username = document.getElementById("username");

    username_error.style.maxHeight = '0';
    username.style.background = 'white';

    const button = document.getElementById("submit");

    const xhr = new XMLHttpRequest();

    let url = 'http://localhost:8080/ks/check-registration?username=' + username.value;
    xhr.open('GET',  url, false);
    xhr.send();
    if (xhr.status !== 200) {
        window.location.href = "something_happened";
    } else {
        const result = xhr.responseText;
        if (result === 'true') {
            document.getElementById("username_error").style.maxHeight = '200px';
            document.getElementById("username").style.background = 'pink';
            button.disabled = true;
        }
    }
}

function check_passwords() {
    document.getElementById("passwords_error").style.maxHeight = '0';
    document.getElementById("repeat_password").style.background = 'white';

    const password1 = document.getElementById("password");
    const password2 = document.getElementById("repeat_password");
    const passwords_error = document.getElementById("passwords_error");
    const button = document.getElementById("submit");

    if (password1.value !== password2.value) {
        passwords_error.style.maxHeight = '200px';
        password2.style.background = 'pink';
        button.disabled = true;

    } else {
        passwords_error.style.maxHeight = '0';
        password2.style.background = 'white';
        button.disabled = false;
    }
}