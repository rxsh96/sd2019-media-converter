$('#GFG_UP').text("Elija el archivo a convertir"); 
$('#File').on('change', function() { 
	if (this.files[0].size > 2097152) { 
			alert("Try to upload file less than 2MB!"); 
	} else { 
			$('#GFG_DOWN').text(this.files[0].size + "bytes"); 
	} 
}); 


$('#GFG_UP2').text("Elija el archivo a convertir"); 
$('#File2').on('change', function() { 
	if (this.files[0].size > 2097152) { 
			alert("Try to upload file less than 2MB!"); 
	} else { 
			$('#GFG_DOWN2').text(this.files[0].size + "bytes"); 
	} 
}); 


$('#GFG_UP3').text("Elija el archivo a convertir"); 
$('#File3').on('change', function() { 
	if (this.files[0].size > 2097152) { 
			alert("Try to upload file less than 2MB!"); 
	} else { 
			$('#GFG_DOWN3').text(this.files[0].size + "bytes"); 
	} 
}); 