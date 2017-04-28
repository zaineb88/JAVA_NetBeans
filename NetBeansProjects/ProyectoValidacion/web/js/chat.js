function cargarMensajes(tipoCarga, callback) {
    let xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE ) {
           if (xmlhttp.status == 200) {
               callback(xmlhttp.responseText);
           }
           else if (xmlhttp.status == 400) {
              alert('No se puede acceder al servidor');
           }
           else {
              alert('Hay un error desconocido');
           }
        }
    };

    xmlhttp.open("GET", "Chat?mode="+tipoCarga, true);
    xmlhttp.send();
}

function sendMessage(){

    let user = document.getElementById('user').value;
    let message = document.getElementById('message').value;
    let xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE ) {
           if (xmlhttp.status == 200) {
               console.log("Mensaje enviado");
           }
           else if (xmlhttp.status == 400) {
              alert('No se puede acceder al servidor');
           }
           else {
              alert('Hay un error desconocido');
           }
        }
    };

    xmlhttp.open("POST", "Chat?mode=insert", true);
    let msg = {"autor":user, "contenido":message};
    console.log(msg);


    xmlhttp.send(JSON.stringify(msg));

}


function mainLoop(){
  setInterval( () => {
      cargarMensajes("loadNew", (data) => {
       if(data){
         let array = JSON.parse(data);
         if(array){
         for(let i=0;i<array.length;i++){
          let chat = document.getElementById("chat");
          chat.innerHTML += array[i].autor+" - "+array[i].contenido+"<br>";
          }
        }
       }
    })
  }, 200);
}


(function(){

 cargarMensajes("loadOld", (data) => {
       if(data){
        let array = JSON.parse(data);
          if(array){
            let chat = document.getElementById("chat");
            for(let i=0;i<array.length;i++){
          
            chat.innerHTML += array[i].autor+" - "+array[i].contenido+"<br>";
          }
         }
       }
     setTimeout(mainLoop, 250);
    });

 

})();