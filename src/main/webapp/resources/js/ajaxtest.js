/**
 * 
 */
//console.log('123 �ѱ�');
const textValue = document.getElementById('textValue');
const btnSend = document.getElementById('btnSend');
const divOut = document.getElementById('divOut');

const xhttp = new XMLHttpRequest();

xhttp.addEventListener('readystatechange', (e) => {
    
    const readyState = e.target.readyState;    

    if(readyState == 4){
        const responseText = e.target.responseText;
        const httpStatus = e.target.status;
        const result = JSON.parse(responseText)

        if(httpStatus == 200){
            divOut.innerText = result.result;
            divOut.style.color = 'green';
        }else{
            divOut.innerText = responseText;
            divOut.style.color = 'red';
        }
    }
});

btnSend.addEventListener('click', (e) => {

    const sendData = {
         "value" : textValue.value
    }

    const vaule = textValue.value;

    xhttp.open('POST', '/restful/pattern/password');
    
    // ��û �ش� ����
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');    
    // Object -> JSON (stringfy)
    //console.log(JSON.stringify(sendData));
    xhttp.send(JSON.stringify(sendData));
});