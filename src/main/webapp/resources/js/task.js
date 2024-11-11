$(document).ready(function () {
    $("select#taskType").on('change', function () {
        if ($("select#taskType").val() != 1) {
            $("div.box-parent").css({"display": "block"});
        } else {
            $("div.box-parent").css({"display": "none"});
        }
    })
});