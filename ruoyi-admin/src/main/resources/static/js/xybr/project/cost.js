//饼图
function createCost(bar,project) {
    var mainData = [];
    mainData.push({
        name: '实际成本',
        value: 342305
    });
    mainData.push({
        name: '目标成本',
        value: 1332042
    });
    mainData.push({
        name: '差额',
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
            if(i===0){
                paramColor = "#ff9f7f";
                result.push({
                    type: 'pie',
                    center: ['20%', '28%'], // 20%  50%  80%
                    radius: ['45%', '55%'],
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
            if(i===1){
                paramColor = "#9fe6b8";
                result.push({
                    type: 'pie',
                    center: ['80%', '28%'], // 20%  50%  80%
                    radius: ['45%', '55%'],
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
            if(i===2){
                paramColor = "#32c5e9";
                result.push({
                    type: 'pie',
                    center: ['50%', '62%'], // 20%  50%  80%
                    radius: ['45%', '55%'],
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