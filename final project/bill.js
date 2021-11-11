document.getElementById("adc").style.display="none";

function adc(){
    document.getElementById("payment").style.display="none";
    document.getElementById("gpc").style.display="none";
    document.getElementById("pc").style.display="none";
    document.getElementById("adc").style.display="block";
    document.getElementById("m1").style.backgroundColor="burlywood";
   
    document.getElementById("adr").style.backgroundColor="burlywood";
    document.getElementById("adr").style.opacity="0.6";
    document.getElementById("adr").style.color="red";
   document.getElementById("nav").addEventListener("click",check);
 
   function check(){
       let addr = document.getElementById("addr").value;
       let name = document.getElementById("nm").value;
       let pm = document.getElementById("email").value;
       let reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
       if(name.length == 0){
           alert("Name Can't Be empty");
       }
      else if(reg.test(pm) == false){
          alert("Enter a valid Email Id ");
      }
       else if(addr.length == 0){
          alert("Address Can't be Empty");
       }
       else{
        document.getElementById("nav").addEventListener("click",mode);
       }
   }
}


function gp(){
    document.getElementById("adc").style.display="none";
    document.getElementById("gpc").style.display="block";
    document.getElementById("pc").style.display="none";
    document.getElementById("payment").style.display="none";
  document.getElementById("py").addEventListener("click",check);
  function check(){
      var upid = document.getElementById("Uid").value;
      var pwd = document.getElementById("pwd").value;
      if(upid.length == 0){
          alert("Upi Id Can't be Empty");
      }
      else if(pwd.length == 0){
          alert("Password Can't be Empty");
      }
      else if(upid!='aditya@okici' || pwd!='123'){
          alert("Invalid Credentials");
      }
      else{
        
        Swal.fire({
            title: 'Sucess',
            text: "Download Invoice",
            icon: 'success',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
          }).then((result) => {
            if (result.isConfirmed) {
                window.location.href="invoice.html";
            }
          })
      }
  }
  function redirect(){
      
  }
}
function pod(){
    Swal.fire({
        title: 'Sucess',
        text: "Download Invoice",
        icon: 'success',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
      }).then((result) => {
        if (result.isConfirmed) {
            window.location.href="invoice.html";
        }
      })
}
function payd(){
    location.href="invoice.html";
}
function mode(){
    document.getElementById("payment").style.display="block";
    document.getElementById("adc").style.display="none";
    document.getElementById("gpc").style.display="none";
    document.getElementById("pc").style.display="none";
    document.getElementById("gp").style.backgroundColor="burlywood";
    document.getElementById("gp").style.color="red";
    document.getElementById("gp").style.opacity="0.6";
    document.getElementById("m2").style.backgroundColor="burlywood";
    
}
