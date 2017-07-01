function mouseMenu(option, exTags = 'input|textarea') {
    var format = '<div id="mouse-menu" style="z-index:-1">' +
        '<span class="end-menu glyphicon glyphicon-remove"></span>' +
        '<div class="rack-menu">' +
        '</div>' +
        '</div>'
    $('body').append(format)
    for (var i in option) {
        var html = option[i].html
        $('#mouse-menu .rack-menu').append(html)
    }

    var deg = 0
    $(document).on('dblclick', function (event) {


        var parn = new RegExp(exTags, 'g')
        if (parn.test($(event.target)[0].tagName.toLowerCase()))
            return false
        var point = {
            top: event.pageY - 18,
            left: event.pageX - 48,
            opacity: 1
        }

        function getNewPoint(space, point) {
            var newPoint = {opacity: 1, 'z-index': 9999}
            if (point.left < space) {
                newPoint.left = space
            } else {
                newPoint.left = ($(document).width() - point.left) < space ? $(document).width() - space : point.left
            }
            if (point.top < space) {
                newPoint.top = space
            } else {
                newPoint.top = ($(document).height() - point.top) < space ? $(document).height() - space : point.top
            }
            return newPoint
        }

        point = getNewPoint(155, point)
        $('#mouse-menu').css(point)
        $('.rack-menu > span').addClass('item-menu');

        var items = $('.rack-menu .item-menu')

        items.each(function (index, element) {
            $(element).animate({'top': `${33 * index}px`}, 200)
        })

    })

    $('#mouse-menu .end-menu').on('click', function () {

        var items = $('.rack-menu .item-menu')

        items.each(function (index, element) {
            $(element).animate({'top': `0px`}, 200)
        })

        $('#mouse-menu').css({'opacity': 0, 'z-index': -1})
    })
}
