//饼图
function createBudgeExp(bar,project) {
    var mainData = [];
    mainData.push({
        name: '预算',
        value: 342305
    });
    mainData.push({
        name: '支出',
        value: 1332042
    });

    function createSeries(mainData) {
        var result = [];
        var insideLabel = {
            normal: {
                position: 'center',
                formatter: function(params) {
                    if (params.name == "other")
                        return "";
                    return params.value + '\n' + params.name;
                },
                textStyle: {
                    fontStyle: 'normal',
                    fontWeight: 'bold',
                    fontSize: nowSize(18)
                }
            }
        };
        for (var i = 0; i < mainData.length; i++) {
            var paramColor = "brown";
            if(i===1){
                paramColor = "#4CAF50";
            }
            result.push({
                type: 'pie',
                center: [i * 50 + 25 + '%', '50%'], // 30%  70%
                radius: ['40%', '60%'],
                label: insideLabel,
                data: [{
                    name: mainData[i].name,
                    value: mainData[i].value
                }],
                itemStyle: {
                    normal: {
                        color: paramColor
                    }
                }
            });
        }
        return result;
    }
    let option = {
        toolbox: {
            show: true,
            feature: {
                dataView: {
                    show: false,
                    readOnly: true
                },
                restore: {
                    show: false
                },
                saveAsImage: {
                    show: false
                }
            }
        },
        series: createSeries(mainData)
    }
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}