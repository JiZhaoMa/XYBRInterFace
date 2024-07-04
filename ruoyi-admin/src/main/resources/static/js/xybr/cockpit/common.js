function getCockpitData(monthValue) {
    $.ajax({
        type: "GET",
        url: urls + "/system/cockpit/getViewData",
        contentType: "application/json;charset=utf-8",
        data: {
            "monthStr": monthValue
        },
        dateType: "json",
        success: function (data) {
            return data;
        },
        error: function (data) {
            alert("失败");
        }

    });
}