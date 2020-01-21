const appImage=new Vue({
    el:'#appImage',
    
    methods:{
        convertirImagen(){
            var input=document.querySelector('input[type="file"]')
            var datos=new FormData()
            datos.append('image',input.files[0])
            fetch('http://08786c79.ngrok.io/pngimage',{
              method:'POST',
              body:datos  
            })
            .then(response => Promise.all([response.status, response.json()]))
            .then(function([status, myJson]) {
              if (status == 200) {
                  console.log("succeed!");
              } else {
                  console.log("failed!");
              }
          })
          .catch(error => console.log(error.message));
        }
    }
})