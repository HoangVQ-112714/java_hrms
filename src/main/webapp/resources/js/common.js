$(document).ready(function () {
    $('.nav-menu').one('click', function () {
        var btn = $(this).attr("btn");
        $("a").atrr("class", btn).click();
    });

    const currentPath = window.location.pathname;
    const regex = /^\/user\/update\/\d+$/;
    if (regex.test(currentPath)) {
        jQuery("input#userPass").val("")
    }
});