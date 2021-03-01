$(function() {
	$('[data-toggle="tooltip"]').tooltip()
})

function stoppedTyping() {
	if (document.getElementById('nom').value.length > 0
		&& document.getElementById('label').value.length > 0
		&& document.getElementById('prix').value.length > 0) {
		document.getElementById('submit').disabled = false
	} else {
		document.getElementById('submit').disabled = true
	}
}

function myStoppedTyping() {
	if (document.getElementById('nombre').value.length > 0
		&& document.getElementById('cryptoId').value.length > 0) {
		document.getElementById('submit').disabled = false
	} else {
		document.getElementById('submit').disabled = true
	}
}

function myStopped() {
	if (document.getElementById('nombre').value.length > 0) {
		document.getElementById('submit').disabled = false
	} else {
		document.getElementById('submit').disabled = true
	}
}