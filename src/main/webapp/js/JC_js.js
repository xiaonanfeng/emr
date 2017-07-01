// JavaScript Document

//isPad

var window_width = $(window).width();//页面宽度 
var window_height = $(window).height();//页面高度
var Frame_right_width, Frame_right_height;
var father_width = window_width - 300;//页面宽度
var father_width = top.$("#index_body").width() - 300;//页面宽度
var father_height = top.$("#index_body").height();//页面gao度 

var zindex_a = 0, i_page = 0;
$.ajaxSetup({cache: false});
$(document).ready(function () {
    $.ajaxSetup({cache: false});

    //$("#Frame_menu").load("left_menu.html");
    new_clock();
    $("#my_clock").fadeIn();
    setInterval(new_clock, 1000);
    $("#rili").fadeIn();
    $("#my_week").text(weekNames[Stamp.getDay()]);
    $("#my_riqi").text(Stamp.getDate());
    var the_year = Stamp.getFullYear() + " " + monthNames[Stamp.getMonth()];
    $("#my_year").text(the_year);
    $("#Frame_menu").mouseover(function () {
        $("#Frame_menu").addClass("Frame_menu_over");
    });
    $("#Frame_menu").mouseout(function () {
        $("#Frame_menu").removeClass("Frame_menu_over");
    });

    /****************    **********************/

    var Frame_menu_move_key = 0;
    $("#Frame_menu_move").click(function () {

        if (Frame_menu_move_key == 0) {
            Frame_menu_move_key = 1;
            $(this).removeClass("menu_move_right");
            $(this).addClass("menu_move_right");
            $(this).parent("div").animate({left: "-200px",}, 500);
            var new_right_width = $("#Frame_right_box").width() + 215;
            $("#Frame_right_box").animate({width: new_right_width,}, 500);
        } else {
            Frame_menu_move_key = 0;
            $(this).removeClass("menu_move_right");
            $(this).parent("div").animate({left: "10",}, 500);
            var new_right_width = $("#Frame_right_box").width() - 215;
            $("#Frame_right_box").animate({width: new_right_width,}, 500);
        }
    })

    ////top_menu 导航栏
    //$('#top_menu').on('click', '.top_menu_button',function(){
    $("#top_menu button.top_menu_button").click(function () {
        $.ajaxSetup({cache: false});
        $("#Frame_right_ico").hide();
        //$("#index_body").removeClass("index_body_img");
        $("#top_menu .top_menu_button").removeClass("top_menu_button_on");
        $(this).addClass("top_menu_button_on");
        var link_URL = $(this).attr("link_URL");
        $("#Frame_menu_left").attr("src", link_URL);
        $("#Frame_menu").show();
        $("#Frame_menu").addClass("Frame_menu_over");
    });
    $("#top_menu button.top_menu_out").click(function () {
        $.ajaxSetup({cache: false});
        var link_URL = $(this).attr("link_URL");
        location.href = link_URL;
    });

    $("#index_gnmk a[openLeft='OK']").click(function () {
        var link_URL = $(this).attr("href");
        $("#Frame_menu_left").attr("src", link_URL);
        $("#Frame_menu").show();
        $("#Frame_menu").addClass("Frame_menu_over");
        alert(link_URL)
        return false;
    });
    //动态创建导航栏
    //$('#Frame_menu_left').on('click', '#left_menu li',function(){
    $(".left_menu_box dd").hide();
    $(".left_menu_box dt").click(function () {
        $(this).parent().find('dd').removeClass("menu_chioce");
        $(".menu_chioce").slideUp();
        $(this).parent().find('dd').slideToggle();
        $(this).parent().find('dd').addClass("menu_chioce");
        $(".left_menu_box dl").removeClass("left_menu_click");
        $(this).parent().addClass("left_menu_click");
    });

    $("#left_menu_box dd").click(function () {
        $.ajaxSetup({cache: false});
        top.$("#Frame_right_ico").hide();
        var link_id = $(this).attr("id");
        var title_id = $(this).attr("id") + "_title";
        var nr_id = title_id + "_nr";
        var nr_url = $(this).attr("link_URL");
        var cece = nr_id.replace("_nr", "");
        var menu_title = $(this).text();
        var top_page_sonK = 0;//总width
        var my_array = [];
        top.$("#Frame_tab_ul").find("li").each(function () {
            top_page_sonK += $(this).innerWidth() + 4;
            var array_ID = $(this).attr("id");
            my_array.push(array_ID);
        });
        //window.parent.$("#logo").text(my_array);
        var my_array_num = $.inArray(title_id, my_array);
        if (my_array_num == -1) {
            if (top_page_sonK + 100 < father_width) {
                ///创建导航栏
                //创建导航的时候 初始化首个导航
                $.ajaxSetup({cache: false});
                window.parent.$("Frame_pages iframe").each(function () {
                    $(this).hide();
                });
                window.parent.$("#right_index_box").hide();
                window.parent.$("#Frame_tab_ul li").removeClass("Frame_tab_bg02");
                window.parent.$("#index_page").removeClass("Frame_tab_bg02");
                zindex_a++;
                var new_tab_title = "<li class='Frame_tab_bg01 Frame_tab_bg02' title='双击刷新' id='" + title_id + "' >" + menu_title + "<div class='toppage_close'></div></li>";
                window.parent.$("#Frame_tab_ul").append(new_tab_title);
                var new_iframe = "<iframe frameborder='0' class='Frame_right_page' id='" + nr_id + "' name='" + nr_id + "' src='" + nr_url + "'></iframe>"
                window.parent.$("#Frame_pages").append(new_iframe);
                window.parent.$("#right_index_box").hide();

            } else {
                open_layer("提示信息", "prompt_savefailed.html", "500", "220");
                $("#iframe_layer", window.top.document).load(function () {
                    $("#iframe_layer", window.top.document).contents().find("#other_layer td").text("请关闭一些菜单后，再打开！");
                });
            }
        } else {
            //$("ul li:eq(3)")
            var ID_obj = "#Frame_tab_ul li:eq(" + my_array_num + ")";
            window.parent.$("#Frame_tab_ul li").removeClass("Frame_tab_bg02");
            window.parent.$(ID_obj).addClass("Frame_tab_bg02");
            window.parent.$("#Frame_pages iframe").hide();

            var iframe_this = "#Frame_pages iframe:eq(" + my_array_num + ")";
            //alert(nr_id)
            window.parent.$(iframe_this).show();
        }
    });


    //点击标题
    $('#Frame_tab_ul').on('click', 'li', function () {
        var click_id = $(this).attr("id");
        $("#Frame_tab_ul li").removeClass("Frame_tab_bg02");
        $(this).addClass("Frame_tab_bg02");
        var find_nr_id = "#" + click_id + "_nr";
        $("#Frame_pages iframe").hide();
        $(find_nr_id).show();
        $("#index_page").removeClass("Frame_tab_bg02");
        $("#right_index_box").hide();
    });

    //关闭标题栏
    $('#Frame_tab_ul').on('click', 'div.toppage_close', function (event) {
        var HQ_nr_id2 = "#" + $(this).parent().attr("id") + "_nr";
        $(this).parent().remove();
        $(HQ_nr_id2).remove();
        $("#Frame_tab_ul li").removeClass("Frame_tab_bg02");
        $("#Frame_tab_ul li:last").addClass("Frame_tab_bg02");
        $("#Frame_pages iframe").hide();
        $("#Frame_pages iframe:last").show();
        var papa_id = "#" + $(this).parent().attr("papa_id");
        if (typeof(papa_id) == "undefined") {
        } else {
            var find_id = "[biaozhi=" + $(this).parent().attr("id").replace("_title", "") + "]";
            $(papa_id).contents().find(find_id).removeAttr("biaozhi");
        }
        if ($('#Frame_tab_ul li').length < 1) {
            window.parent.$("#right_index_box").show();
            window.parent.$("#index_page").addClass("Frame_tab_bg02");
        }
        event.stopPropagation();
        return false;
    })


    $("#index_page").click(function () {
        $("#Frame_tab_ul li").removeClass("Frame_tab_bg02");
        $(this).addClass("Frame_tab_bg02");
        $("#Frame_pages iframe").hide();
        $("#right_index_box").show();
    })
    //关闭所有标题栏
    $("#Frame_tab_clear").click(function () {
        $("#Frame_tab_ul li").remove();
        $("#Frame_pages iframe").remove();
        $("#right_index_box").show();
        $("#index_page").addClass("Frame_tab_bg02");
    })
    //双击刷新
    $('#Frame_tab_ul').on('dblclick', 'li', function () {
        var click_id = $(this).attr("id");
        var find_nr_id = "#" + click_id + "_nr";
        var nr_url = $(find_nr_id).attr("src");
        $(find_nr_id).attr('src', $(find_nr_id).attr('src'));

    });
    /****/
    $(".select_checkbox_div").focusin(function () {
        $(this).addClass("input_field custom_key");
        var input_width = $(this).find("input.select_checkbox_input").innerWidth();
        $(this).find("div.select_checkbox_box").width(input_width);
        $(this).find("div.my_custom_select li").innerWidth(input_width / 2 - 1);


    });
    $(".select_checkbox_div").focusout(function () {
        $(this).removeClass("input_field ");
        //alert($(this).find("ul.select_checkbox_ul01"));
        var new_val = "";
        var HQ_array = $(this).find("ul.select_checkbox_ul01 li");

        $(this).find("ul.select_checkbox_ul01 li").each(function () {
            new_val += $(this).text() + ",";
        });
        $(this).find("input.select_checkbox_input").val(new_val)

        $(this).removeClass("custom_key");
        //var HQ_arr = jQuery.makeArray( HQ_array );
        //var yourString=$(this).find("input.select_checkbox_input").val();
        //alert(HQ_array)


    });
    $(".select_checkbox_box").on('click', 'ul.select_checkbox_ul02 li', function () {
        $(this).parent().prev("ul").append($(this))
    });
    $(".select_checkbox_box").on('click', 'ul.select_checkbox_ul01 li', function () {
        $(this).parent().next("ul").append($(this))
    });

    /***********单选************/
    $("input[type=radio]").each(function () {
        var superBox = $(this).attr("superBox");
        if (superBox != "normal") {
            if ($(this).is(":checked")) {
                $(this).addClass('YC_choose');
                $(this).wrap("<span class='input_out'></span>");
                $(this).after($("<div class='new_radio new_radio_yes'></div>"));
            } else {
                $(this).addClass('YC_choose');
                $(this).wrap("<span class='input_out'></span>");
                $(this).after($('<div class=new_radio></div>'));
            }
        }
    })
    $('input[type=radio]').next("div").on('click', function () {
        var radio_name = $(this).prev().attr("name");
        $("input[type=radio][name=" + radio_name + "]").each(function () {
            $(this).next().removeClass('new_radio_yes');
        });
        $(this).addClass('new_radio_yes');
        $(this).prev().trigger("click")
    })

    $("input[type=checkbox]").each(function () {
        var superBox = $(this).attr("superBox");
        if (superBox != "normal") {
            $(this).addClass('YC_choose');
            if ($(this).is(":checked") == true) {
                $(this).wrap("<span class='input_out'></span>");
                $(this).after($("<div class='new_checkbox new_checkbox_yes'></div>"));
            } else {
                $(this).wrap("<span class='input_out'></span>");
                $(this).after($('<div class=new_checkbox></div>'));
            }
        }
    })

    $('input[type=checkbox]').next("div").on('click', function () {
        var obj_checked = $(this).prev().is(":checked");
        $(this).prev().trigger("click");
        var checkbox_name = $(this).prev().attr("name");
        var choose = $(this).prev().attr("choose");
        if (obj_checked == true) {
            $(this).removeClass('new_checkbox_yes')
            $(this).prev().is(':disabled')
        } else {
            $(this).addClass('new_checkbox_yes');
            $(this).prev().is(':checked')
        }
    })

    /***********select****    ********/
    $(document).on("input propertychange", ".new_select_input", function () {
        var right_now_val = $(this).val();
        $(this).parent().find("dl dd").each(function () {
            $(this).show();
            if ($(this).text().indexOf(right_now_val) >= 0) {
            }
            else {
                $(this).hide();
            }
        });
    });
    $(document).on('focusin', 'span.new_select_box', function () {
        $(this).find("dl").stop(true, false).slideDown(200);
    });
    $(document).on("click", ".new_select_box dd", function () {
        var inputObj = $(this).parent().prev("input");
        if (inputObj.attr("disabled") == 'disabled') {//如果input父类不是readonly
        } else {
            $(this).parent().parent().prev("label").hide();
            var the_val = $(this).text();
            var the_index = $(this).index();
            inputObj.val(the_val);
            $(this).parent().stop(true, false).slideUp(200);
            $(this).siblings().removeClass("select_selected");
            $(this).addClass("select_selected");
            var the_select = $(this).parent().parent().parent().find("select");
            the_select.attr("disabled", false);
            //if(the_select="undefined"){the_select = $(this).parent().parent().prev("select");}
            //$(this).parent().parent().prev("select");
            var option_value = the_select.find("option").eq(the_index).attr("value");
            //the_select.attr("value", option_value);
            //console.log(option_value);
            the_select.val(option_value);//给select赋值
            the_select.change();//change方法
            /************
             the_select.val("");
             the_select.find("option").eq(the_index).siblings().attr("selected",false);
             the_select.find("option").eq(the_index).attr("selected", true);
             *****/
            //alert(option_value + "----" + the_select.val());
            //alert(the_select.val() + "----" + the_index);
        }
    });

    $(document).on('focusout', 'span.new_select_box', function () {
        $(this).find("dl").stop(true, false).slideUp(200);
    });

    /**
     $("select").each(function(index, element) {
		var superSelect = $(this).attr("superSelect");
		if(superSelect!="normal"){
			createSelect(this);//创建select
		}
	});
     **/

    //页面内点开超链接
    $(document).on('click', 'a', function () {
        if ($(this).attr("openMode") == "tabMenu") {

            var biaozhi = $(this).attr("biaozhi");
            var menu_title = $(this).attr("tab_title");
            var nr_url = $(this).attr("link_URL");
            if (typeof(menu_title) == "undefined") {
                menu_title = $(this).text();
            }
            if (typeof(biaozhi) == "undefined") {
                var now = new Date();
                biaozhi = "CD_" + now.getDate() + now.getHours() + now.getMinutes() + now.getSeconds();
                $(this).attr("biaozhi", biaozhi);
            }
            var link_id = biaozhi;
            var title_id = biaozhi + "_title";
            var nr_id = title_id + "_nr";
            var pID = window.name;
            var top_page_sonK = 0;//总width
            var my_array = [];
            window.parent.$("#Frame_tab_ul li").each(function () {
                top_page_sonK += $(this).innerWidth() + 4;
                var array_ID = $(this).attr("id");
                my_array.push(array_ID);
            });
            if (top_page_sonK + 100 < father_width) {
                ///创建导航栏
                //创建导航的时候 初始化首个导航
                $.ajaxSetup({cache: false});
                window.parent.$("#Frame_tab_ul li").removeClass("Frame_tab_bg02");
                var new_tab_title = "<li class='Frame_tab_bg01 Frame_tab_bg02' id='" + title_id + "' papa_id=" + pID + " >" + menu_title + "<div class='toppage_close'></div></li>";
                window.parent.$("#Frame_tab_ul").append(new_tab_title);
                var new_iframe = "<iframe frameborder='0' class='Frame_right_page' id='" + nr_id + "' name='" + nr_id + "' src='" + nr_url + "'></iframe>"
                window.parent.$("#Frame_pages").append(new_iframe);
                window.parent.$("#right_index_box").hide();
                window.parent.$("#Frame_pages iframe").each(function () {
                    $(this).hide();
                })
                var new_nr_id = "#" + nr_id;
                window.parent.$("#index_page").removeClass("Frame_tab_bg02");
                window.parent.$(new_nr_id).css("display", "block");
            } else {
                $(this).removeAttr("biaozhi");
                open_layer("提示信息", "prompt_Warning.html", "500", "220");
                $("#iframe_layer", window.top.document).load(function () {
                    $("#iframe_layer", window.top.document).contents().find("#other_layer td").text("请关闭一些菜单后，再打开！");
                });
            }

        }
        //open_layer
        if ($(this).attr("openMode") == "open_layer") {
            var the_link = $(this).attr("link_URL");
            var the_title = $(this).attr("tab_title");
            var the_width = $(this).attr("layer_width");
            var the_heigth = $(this).attr("layer_heigth");
            open_layer(the_title, the_link, the_width, the_heigth);

        }
        //新页面
        if ($(this).attr("openMode") == "newWin") {
            var the_link = $(this).attr("link_URL");
            var the_title = $(this).attr("tab_title");
            window.open(the_link);

        }
    });


    $("#tab_div_BL .tab_div_dt").click(function () {
        $(this).siblings().removeClass("tab_div_dt_active");
        $(this).addClass("tab_div_dt_active");
        var this_NUM = $(this).index();
        var next_li = $('#tab_items > li');
        next_li.hide();
        next_li.eq(this_NUM).show();
    });

    $(".choose_next").click(function () {
        var the_index_li = $(this).parents("li").index() + 1;
        $(this).parents("li").hide();
        $(this).parents("ul").find("li").eq(the_index_li).show();
        $(this).parents(".tab_div").find("dl dt.tab_div_dt").removeClass("tab_div_dt_active");
        $(this).parents(".tab_div").find("dl dt.tab_div_dt").eq(the_index_li).addClass("tab_div_dt_active");
    });


});


////弹出层
function open_layer(the_layer_title, link_url, Custom_width, Custom_height) {
    window.parent.$("#the_zhezhao").css("display", "block");
    $.ajaxSetup({cache: false});
    window.parent.$("#iframe_layer").attr({"src": link_url});
    window.parent.$("#layer_title").text(the_layer_title);
    var layer_width = window.parent.$("#layer_box").outerWidth();
    var layer_height = window.parent.$("#layer_box").outerHeight() + 30;
    //var relationships_ID = self.frameElement.getAttribute('id');
    var relationships_ID;
    //console.log(self);
    //console.log(self.frameElement);
    if (self.frameElement == null) {
    } else {
        relationships_ID = self.frameElement.getAttribute('id');
    }
    window.parent.$("#layer_box").attr("relationships_ID", relationships_ID);
    window.parent.$("#layer_box").css({
        "margin-top": -layer_height / 2,
        "margin-left": -layer_width / 2,
        "display": "block"
    });
    var layer_width_2;
    var layer_height_2;
    if (Custom_width == "" || Custom_width == null) {
        layer_width_2 = window_width * 0.8;
    } else {
        layer_width_2 = Custom_width;
    }
    if (Custom_height == "" || Custom_height == null) {
        layer_height_2 = window_height;
    } else {
        layer_height_2 = Custom_height;
    }
    window.parent.$("#layer_box").animate({
        width: layer_width_2,
        height: layer_height_2,
        marginLeft: -layer_width_2 / 2,
        marginTop: -layer_height_2 / 2
    }, 500);
    window.parent.$("#index_loading_bg").animate({
        width: layer_width_2,
        height: layer_height_2 - 30,
    }, 500);
    window.parent.$("#iframe_layer").animate({
        width: layer_width_2,
        height: layer_height_2 - 30,
    }, 500);
    setTimeout(function () {
        window.parent.$("#index_loading_bg").css("display", "none");
        window.parent.$("#iframe_layer").css("display", "block");
    }, 600);

}

/////弹出层 关闭按钮
function closed_layer(the_id) {
    //window.parent.$("#iframe_layer").attr("src","loading.html");
    window.parent.$("#index_loading_bg").css("display", "block");
    window.parent.$("#iframe_layer").css("display", "none");
    window.parent.$("#layer_box").animate({
        width: "300px",
        height: "160px",
        marginLeft: "-150px",
        marginTop: "-80px"
    }, 300);
    window.parent.$("#layer_box").attr("relationships_ID", "");
    window.parent.$("#index_loading_bg").animate({
        width: "300px",
        height: "120px",
    }, 300);
    window.parent.$("#iframe_layer").animate({
        width: "300px",
        height: "120px",
    }, 300);
    //$("#layer_box").css({"width":"400px","height":"200px","margin-left":"-200px","margin-top":"-100px"})
    setTimeout(function () {
            window.parent.$("#the_zhezhao").css("display", "none");
            window.parent.$("#iframe_layer").attr("src", "");
            window.parent.$("#layer_box").css("display", "none");
        },
        300);

}

function new_clock() {
    var date = new Date().getDate(),//get the current date
        my_hours = new Date().getHours(),//get the current hour
        my_minutes = new Date().getMinutes(),	//get the current minute
        my_seconds = new Date().getSeconds();//get the current second
    var hours_deg = my_hours * 30 + (my_minutes / 2);
    $("#my_hours").css({'transform': 'rotate(' + hours_deg + 'deg)',});
    var minutes_deg = my_minutes * 6;
    $("#my_minutes").css({'transform': 'rotate(' + minutes_deg + 'deg)',});
    var seconds_deg = my_seconds * 6;
    $("#my_seconds").css({'transform': 'rotate(' + seconds_deg + 'deg)',});
}
var weekNames = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
var monthNames = new Array("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月");
Stamp = new Date();


function kuangjia() {
    var window_width = $(window).width();//页面宽度
    var window_height = $(window).height();//页面高度
    var height_header = $("#Frame_top").height();//top宽度
    var height_footer = $("#footer").height();//页脚高度
    var leftmenu_width = $("#Frame_menu").width();//左侧宽度
    var Frame_right_height = window_height - height_header;
    $("#Frame_menu").height(Frame_right_height + 35);
    var Frame_right_width = window_width - 20;
    $("#Frame_right_box").width(Frame_right_width);
    $("#Frame_right_box").height(Frame_right_height);
    $("#Frame_pages iframe").height(Frame_right_height);
    $("#Frame_pages iframe").width(Frame_right_width);
}


//列表中创建展示内容
function build_new_tr(obj, can) {
    var the_lie = $(obj).parent().parent().find("td").length;
    var display_key = $(obj).attr("new_tr");
    var new_NR = can;
    $("[new_tr]").removeAttr("new_tr");
    var timestamp = "AD_" + new Date().getTime();
    if (typeof(display_key) == "undefined") {
        $(".build_new_tr").remove();
        $(".display_new_tr").removeAttr("new_tr");
        $(obj).parent().parent().after("<tr class='build_new_tr'><td id=" + timestamp + " colspan=" + the_lie + " style=''>" + new_NR + "</td></tr>");
        $(obj).attr("new_tr", "yes");
    } else {
        $(".build_new_tr").remove();
        $(this).removeAttr("new_tr");
    }
}

function showalert(shuju) {
    var TS = $("#layer_slow").css("display");
    var the_shuju = shuju + "<div style='text-align:center;'><a href='ZW_add_list.html'  style='line-height:22px; color:#fff;' target='right' class='btn'>点击查看</a</div>>"
    if (TS == "none") {
        $("#slow_box").html();
        var NR = $("#slow_box").html(the_shuju);
        if (NR == "") {
        } else {
            $("#layer_slow").css("display", "block");
            $("#layer_slow").animate({bottom: 0}, 500);
        }
        $('#messageAudio')[0].play();
        //$("#layle_slow_iframe").load("slow.html")
    }
}
/////右下角弹出层 关闭按钮
function closed_slow(the_id) {
    $("#" + the_id).animate({
        bottom: "-160px",
    }, 500);

    $("#slow_box").empty()
    setTimeout(function () {
        window.top.document.getElementById(the_id).style.display = "none"
    }, 500);
    //alert($("#slow_box").html())
}
(function ($) {
    $.fn.extend({
        select_val: function (parameter) {
            $("#ad000").text(parameter);
            var val_key = "";
            $(this).children('option').each(function () {
                if ($(this).val() == parameter) {
                    val_key = $(this).text();
                }
            });
            $(this).next().find("input").val(val_key)
        }
    })
})(jQuery);

/**
 * select公共创建方法
 * @param obj
 */
function createSelect(obj) {
    $(obj).after("<span class='new_select_box' tabindex='-1'><input type='text' readonly class='new_select_input' placeholder=''><dl></dl></span>");
    $(obj).find("option").each(function () {
        var the_option = $(this).text();
        var new_dd;
        if ($(this).is(":selected") == false) {
            new_dd = "<dd>" + the_option + "</dd>";
        } else {
            $(this).parent().next(".new_select_box").find("input").val(the_option);
            new_dd = "<dd class='select_selected'>" + the_option + "</dd>";
        }
        $(this).parent().next().find("dl").append(new_dd);
    });
}

/**
 * 全屏
 * @param element
 */
function launchFullScreen(element) {
    if (element.requestFullscreen) {
        element.requestFullscreen();
    } else if (element.mozRequestFullScreen) {
        element.mozRequestFullScreen();
    } else if (element.webkitRequestFullscreen) {
        element.webkitRequestFullscreen();
    } else if (element.msRequestFullscreen) {
        element.msRequestFullscreen();
    }
}

function SlideBoot(parent, target) {
    this.parent = parent;//容器
    this.target = target;//控制元素
    function changeState() {
        if ($(parent).find('span').hasClass('up-icon')) {
            $(target).slideDown(200);
            $(parent).find('span').removeClass('up-icon').addClass('down-icon');
        } else {
            $(target).slideUp(200);
            $(parent).find('span').removeClass('down-icon').addClass('up-icon');
        }
    }

    this.init = function () {
        $(parent).append('<span class="down-icon"></span>');
        $(parent).on('click', changeState);
    }
}

/**
 * 一键打怪一键升级一键换装
 * @param obj
 * @param l_v
 */
function custom_options(obj, l_v) {
    var objId = obj.attr("id");
    try {
        if (typeof(objId) != "undefined") {
            var type = obj[0].tagName; //从jQuery对象中得到原生的DOM对象判断他是个啥
            if (type == "INPUT" || type == "TEXTAREA") {
                obj.val(l_v);
            } else if (type == "SELECT") {
                obj.val(l_v);
                var num = obj.find("option:selected").index();
                var tddd = obj.find("option:selected").text();
                obj.next("span").find("input").val(tddd);
                obj.next("span").find("dd").removeClass("select_selected");
                obj.next("span").find("dd").eq(num).addClass("select_selected");
            } else if (type == "SPAN") {
                obj.html(l_v);
            }
        }
    } catch (e) {
        alert(e + ":" + obj + ":" + l_v);
        console.log(e + ":" + obj + ":" + l_v);
    }
}

/**
 * 页面传值
 * @param zhi
 * @param form_id
 */
function layer_to_page(layerValue, tarId) {
    var relationships_ID = window.parent.$("#layer_box").attr("relationships_ID");
    //alert(relationships_ID)
    var obj = $(relationships_ID).contents().find(tarId);
}


/**
 * 页面显示控制
 * @param objName
 * @param styleName
 * @param styleValue
 */
function pageCssControl(obj, csskey, cssvalue) {
    obj.css(csskey, cssvalue);
}
	
	
	
	
	
	

	