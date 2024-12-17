//饼图
function createAppType(bar,person,dept,ptype,process,jiaoDiShuMonth,shouQuanMonth) {
    var dataJsonArr = [
        {value:0, name:'发明'},
        {value:0, name:'实用新型'},
        {value:0, name:'外观设计'}
    ];
    let option = {
        backgroundColor:'#ffffff',
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)"
        },
        legend: {
            right: '1%',
            data: [
                { name: "发明", icon: "circle" },
                { name: "实用新型", icon: "circle" },
                { name: "外观设计", icon: "circle" }
            ],
            // 大小 和位置 文字样式
            itemWidth: nowSize(14),
            itemHeight: nowSize(14),
            textStyle: {
                fontSize: nowSize(14),
                color: "#000",
            }
        },
        color:['#00999b','#345e37','#bb2649'],
        series : [
            {
                type: 'pie',
                data: dataJsonArr,
                itemStyle: {
                    normal: {
                        label:{
                            show: true,
                            position:'inside',
                            formatter: '{d}%'
                        },
                        borderColor: '#ffffff',
                        borderWidth: nowSize(16),
                    },
                    labelLine :{show:true}
                }
            }
        ]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/patent/getAppType",
        contentType: "application/json;charset=utf-8",
        data: {
            "dept": dept,
            "person": person,
            "ptype": ptype,
            "process": process,
            "jiaoDiShuMonth": jiaoDiShuMonth,
            "shouQuanMonth": shouQuanMonth,
        },
        dateType: "json",
        success: function (data) {
            option.series[0].data = data.appTypeJsonArr;
            bar.setOption(option,true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        bar.setOption(option, true);
    });
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}