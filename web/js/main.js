function sendDataToBack() {
    var nombre = document.getElementById("nombre").value;
    var paterno = document.getElementById("paterno").value;
    var materno = document.getElementById("materno").value;
    var telefono = document.getElementById("telefono").value;
    var tipopersona = document.getElementById("tipopersona").value;
    $('#loading').show();

    $.post("urlSuperPro", {
        nombre: nombre,
        paterno: paterno,
        materno: materno,
        telefono: telefono,
        tipopersona: tipopersona
    },
            function (data) {
                console.log("Exito");
                console.log(data);
                document.getElementById("loading").style.display="none";
                if (data.resultado) {
                    window.alert("Si fuciono");
                }

            });
    


}


