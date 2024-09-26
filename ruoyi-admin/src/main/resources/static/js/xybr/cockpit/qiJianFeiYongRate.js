function createQiJianFeiYongRate(qiJianFeiYongRate, currentMonth,yearsAgoMonth,agoMonth) {
    // mock数据
    $.ajax({
        type: "GET",
        url: urls + "/system/cockpit/getQIJianFeiYongRate",
        contentType: "application/json;charset=utf-8",
        data: {
            "currentMonth": currentMonth,
            "yearsAgoMonth": yearsAgoMonth,
            "agoMonth": agoMonth,
        },
        dateType: "json",
        success: function (data) {
            const dataArr = {
                xdata: data.typelist,
                vaccination: data.yearsAgoList,
                unvaccinated: data.monthAgoList,
                unvaccinatedTwo: data.monthCurrList,
                rateDataOne: data.ratelist,
            }

// tooltip
            const tooltip = {
                trigger: "axis",
                /*textStyle: { fontSize: '100%' },*/
                formatter: params => {
                    let rander = params.map(item => item.seriesType !== "pictorialBar" ? `<div>${item.seriesName}: ${item.seriesType !== "line" ? item.value : item.value + "%"}</div>` : '').join('')
                    return `
            <div>${params[0].axisValue}</div>
            ${rander}
        `
                }
            }
            const legend = {
                data: [yearsAgoMonth, agoMonth, currentMonth],
                textStyle: { color: "#00c7ff",fontSize: nowSize(),},
                itemWidth: 25,
                itemHeight: 15,
                itemGap: 15,
                top: '6%',
                align: 'right',
                selectedMode: false
            }
            const grid = {top: '25%',left: '10%', right: '10%', bottom: '4%',
                containLabel: true}
// xAxis
            const xAxis = {
                axisTick: { show: true },
                axisLine: { lineStyle: { color: 'rgba(255,255,255, .2)' } },
                axisLabel: { textStyle: { color: "#00c7ff",fontSize: nowSize(),  }, },
                data: dataArr.xdata
            }

// yAxis
            const yAxis = [{
                axisTick: { show: false },
                axisLine: { show: false, },
                splitLine: { lineStyle: { color: 'rgba(255,255,255, .05)' } },
                axisLabel: { textStyle: { color: "#00c7ff",fontSize: nowSize(), } }
            },{
                show: true,
                splitLine: { show:false },
                axisLine: { show: false },
                axisTick: { show: false },
                axisLabel: {
                    textStyle: { color: "#00c7ff",fontSize: nowSize(), },
                    formatter: params => {
                        return `${params}%`
                    }
                }
            }]

// series
            const series = [{
                z: 1,
                name: yearsAgoMonth,
                type: 'pictorialBar',
                symbolPosition: 'end',
                data: dataArr.vaccination,
                symbol : 'diamond',
                symbolOffset: ['-50%', '-50%'],
                symbolSize: [29, 19],
                itemStyle: {
                    borderColor: '#2fffa4',
                    color: '#2fffa4',
                    fontSize: nowSize(),
                },
            },{
                z: 1,
                type: 'bar',
                name: yearsAgoMonth,
                barWidth: 30,
                barGap: '-50%',
                data: dataArr.vaccination,
                itemStyle: {
                    color: {
                        type: 'linear',
                        x: 0, x2: 1, y: 0, y2: 0,
                        colorStops: [
                            { offset: 0, color: 'rgba(29, 245, 160, .7)' },
                            { offset: 0.5, color: 'rgba(29, 245, 160, .7)' },
                            { offset: 0.5, color: 'rgba(29, 245, 160, .3)' },
                            { offset: 1, color: 'rgba(29, 245, 160, .3)' }
                        ]
                    }
                },
            },{
                z: 2,
                name: agoMonth,
                type: 'pictorialBar',
                symbolPosition: 'end',
                data: dataArr.unvaccinated,
                symbol : 'diamond',
                symbolOffset: [0, '-50%'],
                symbolSize: [29, 19],
                itemStyle: {
                    borderColor: '#32ffee',
                    color: '#32ffee',
                    fontSize: nowSize(),
                },
            },{
                z: 2,
                type: 'bar',
                name: agoMonth,
                barWidth: 30,
                data: dataArr.unvaccinated,
                itemStyle: {
                    color: {
                        type: 'linear',
                        x: 0, x2: 1, y: 0, y2: 0,
                        colorStops: [
                            { offset: 0, color: 'rgba(50, 255, 238, .7)' },
                            { offset: 0.5, color: 'rgba(50, 255, 238, .7)' },
                            { offset: 0.5, color: 'rgba(50, 255, 238, .3)' },
                            { offset: 1, color: 'rgba(50, 255, 238, .3)' }
                        ]
                    }
                },
            }, {
                z: 3,
                name: currentMonth,
                type: 'pictorialBar',
                symbolPosition: 'end',
                data: dataArr.unvaccinatedTwo,
                symbol : 'diamond',
                symbolOffset: ['50%', '-50%'],
                symbolSize: [29, 19],
                itemStyle: {
                    borderColor: '#ffd11a',
                    color: '#ffd11a',
                    fontSize: nowSize(),
                },
            },{
                z: 3,
                type: 'bar',
                name: currentMonth,
                barWidth: 30,
                data: dataArr.unvaccinatedTwo,
                itemStyle: {
                    color: {
                        type: 'linear',
                        x: 0, x2: 1, y: 0, y2: 0,
                        colorStops: [
                            { offset: 0, color: 'rgba(255, 209, 26, .7)' },
                            { offset: 0.5, color: 'rgba(255, 209, 26, .7)' },
                            { offset: 0.5, color: 'rgba(255, 209, 26, .3)' },
                            { offset: 1, color: 'rgba(255, 209, 26, .3)' }
                        ]
                    }
                },
            }, {
                z: 9,
                yAxisIndex: 1,
                name: '营收占比', type: 'line',
                //symbol: `path://M9.312,4.594 C12.074,4.594 14.313,6.832 14.313,9.594 C14.313,12.355 12.074,14.594 9.312,14.594 C6.551,14.594 4.312,12.355 4.312,9.594 C4.312,6.832 6.551,4.594 9.312,4.594 Z`,
                //symbolSize: [10, 10],
                color: {
                    type: 'linear',x: 1, y: 0, x2: 0, y2: 0,
                    // 0% 处的颜色                           // 100% 处的颜色
                    colorStops: [{ offset: 0, color: '#32ffee' }, { offset: 1, color: '#8afff5'}],
                    global: false // 缺省为 false
                },
                lineStyle: { color: {
                        type: 'linear',x: 1, y: 0, x2: 0, y2: 0,
                        // 0% 处的颜色                           // 100% 处的颜色
                        colorStops: [{ offset: 0, color: '#32ffee' }, { offset: 1, color: '#8afff5'}],
                        global: false // 缺省为 false
                    }},
                // 修改的是线下区域的颜色
                areaStyle: {
                    color: new echarts.graphic.LinearGradient(
                        // 右/下/左/上
                        0, 0, 0, 1,[
                            { offset: 0, color: 'rgba(50, 255, 238, .1)' },
                            { offset: 1, color: 'transparent' }
                        ])
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: params => {
                        return `${params.value}%`
                    },
                    textStyle: { fontSize: 12, color: '#FFFFFF',fontSize: nowSize(), }
                },
                data: dataArr.rateDataOne
            }]
            let option = { tooltip, xAxis, yAxis, series, grid, legend, backgroundColor: 'rgb(21,51,114, 0)', }
            qiJianFeiYongRate.setOption(option, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
    window.addEventListener('resize', function() {
        qiJianFeiYongRate.setOption(option, true);
    });
    function nowSize(){
        let nowClientWidth = 12*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}