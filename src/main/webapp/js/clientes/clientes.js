const context = 'http://localhost:8080';

$( document ).ready(function() {
    //showClientes();
});

function showClientes() {
    $.ajax({
		url: context + '/getAllClientes',
		type:'GET',
		contentType: 'application/json',
		success: function(data) {
            if('clientes' === data.tipo){
            	var rows = '';
                data.lista.forEach(function(d) {
                	rows = rows.concat('<tr>');
                    var row = '<td>' + d.id + '</td><td>' + d.fecha_alta + '</td><td>' + 'nombre' + '</td><td>' + 'nombre2' + '</td>';
                    rows = rows.concat(row, '</tr>');
                });
                $('#bodyTable').empty();
                $('#bodyTable').append(rows);
            }
        },
		error: function() {
			console.log('VAYA... ALGO HA SALIDO MAL');
        }
	});
}
