/*
 * Checking if advanced upload is supported.
 * Checking if browser supports drag and drop, data transfer objects
 */
var isAdvancedUpload = function() {
	var div = document.createElement('div')
	return (('draggable' in div) || ('ondragstart' in div && 'ondrop' in div))
			&& 'FormData' in window && 'FileReader' in window
}()

/*
 * Preparing front end
 */
$('.file-drag-n-drop').each(function() {
	fileInput = $(this)
	
	fileInput.css('display','none')
	
	fileInput.attr('id','drop-file-input')
	fileInput.siblings('label').attr('for','drop-file-input')
	
	displayFileGroup = '<div class="drop-file-group">'
	
	displayLabel = '<label for="drop-file-input">'
	if (isAdvancedUpload) {
		displayLabel = displayLabel + '<i class="fa fa-fw fa-upload"></i> Drag a file here or '
	}
	displayLabel = displayLabel + ' <i class="fa fa-fw fa-file"></i> Click to choose a file</label>'
	
	displayFileGroup = displayFileGroup + displayLabel
	displayFileGroup = displayFileGroup + '<ul id="drop-file-list"><li>No files selected yet</li></ul></div>'

	$(displayFileGroup).insertAfter(this)
})

showFilesList = function(files) {
	filesListItem = ''
	$(files).each(function(index) {
		filesListItem = filesListItem + '<li>'+files[index].name+' <i class="fa fa-fw fa-times"></i></li>'
	})
	return filesListItem
}

if (isAdvancedUpload) {
	
	fileBox = $('.drop-file-group label')

	var droppedFiles = false

	fileBox.on('drag dragstart dragend dragover dragenter dragleave drop', function(e) {
		e.preventDefault()
		e.stopPropagation()
	}).on('dragover dragenter', function() {
		//file entered drop area
		fileBox.addClass('file-dragged-over',200)
	}).on('dragleave dragend drop', function() {
		//file left drop area
		fileBox.removeClass('file-dragged-over',200)
	}).on('drop', function(e) {
		//file is dropped
		droppedFiles = e.originalEvent.dataTransfer.files
		//alert(droppedFiles)
		$('#drop-file-list').append(showFilesList(droppedFiles))
	})
}