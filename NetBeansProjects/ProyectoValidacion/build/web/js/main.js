const utils = function(){
  
  let _this = {
    genderlist: ["Masculino", "Femenino", "Unisex"],
    get: (comp) => document.getElementById(comp),
    checkName: (s) => isNaN(s) && s.length >= 3,
    checkPrecio: (p) => !isNaN(p),
    checkGender: (g) => containsValue(g, _this.genderlist),
    checkUrl: (url) => {
    	console.log(url.indexOf('http') != -1);
    	return url.indexOf('http') != -1;
    },
    checkAll: (nombre, precio, gender, url) => 
                    _this.checkName(nombre) && _this.checkPrecio(precio) &&
                _this.checkGender(gender) && _this.checkUrl(url)
   }
   return _this;
}

function containsValue(v,arr) {
    let res = false;
    for(let i=0;i<arr.length;i++){
            if(isNaN(v)){
                    if(v === arr[i]){
                            res = true;
                    }
            }else{
                    if (v == arr[i]){
                            res = true;
                    }
            }
    }
    return res;
}


function validar(){
	
	let nombre = utils().get("nombre").value;
	let precio = utils().get("precio").value;
	let gender = utils().get("gender").value;
	let url = utils().get("url").value;

	if(utils().checkAll(nombre, precio, gender, url)){
		return true;
	}else{
		return false;
	}

}



function checkValues(comp){
	if(validar()){
		utils().get("boton").style.visibility = "visible";
	}else{
		utils().get("boton").style.visibility = "hidden";
    }
		let text;
		switch(comp){
			case 'nombre':
			        text = utils().get('nombre-error');
			    if(isNaN(utils().get('nombre').value)){
					text.style.visibility = "hidden";
                                        
			    }else{
					text.innerHTML = "El nombre debe ser un texto";
				        text.style.visibility = "visible";
                                        
			    }
				break;
		    case 'precio':
		            text = utils().get('precio-error');
                            let precio = utils().get('precio').value;
			        if(!isNaN(precio)){
						text.style.visibility = "hidden";
				    }else{	
						text.innerHTML = "El precio debe ser un número";
					        text.style.visibility = "visible";

				    }
		    	break;
		    case 'url':
		            text = utils().get('url-error');
                            let urlImagen = utils().get('url').value;

			            if(utils().checkUrl(urlImagen)){
						text.style.visibility = "hidden";
				    }else{	
						text.innerHTML = "Debe ser una URL válida";
					    text.style.visibility = "visible";
				    }
		    	break;
		}
		

	}
