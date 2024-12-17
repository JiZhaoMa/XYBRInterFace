function createRisk(bar,project) {
    let option = {
        tooltip: {},
        radar: {
            center: ['50%','55%'],
            radius: nowSize(60),
            // shape: 'circle',
            indicator: [
                { name: '需求', max: 10000}
            ],
            name: {
                formatter: '{value}',
                textStyle: {
                    fontSize: nowSize(12),
                    color: '#000' //外圈标签字体颜色
                }
            },
        },
        series: [{
            name: '风险问题',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : [
                {
                    value : [4300],
                    name : '风险问题',
                    textStyle: {
                        color: 'red' // 设置文字颜色为红色
                    }
                }
            ]
        }]
    };
    $.ajax({
        type: "GET",
        url: urls + "report/project/getRisk",
        contentType: "application/json;charset=utf-8",
        data: {
            "projectCode": projectCode
        },
        dateType: "json",
        success: function (data) {
            if(data.riskTypeList.length > 0){
                option.series[0].data[0].value = data.numList; //风险问题值
                option.radar.indicator.pop();
            }
            for(var i=0; i<data.riskTypeList.length; i++){
                option.radar.indicator.push({ name: data.riskTypeList[i], max: data.maxNumList[i]})
            }
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