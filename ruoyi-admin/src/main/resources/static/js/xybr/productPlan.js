// 生产计划
function createProductChart(eChart, res) {

    let option = {
        title:{
            text:"生产计划",
            textStyle:{
                color:'#ffffff',//'red'，字体颜色
                fontStyle:'normal',//'italic'(倾斜) | 'oblique'(倾斜体) ，字体风格
                fontWeight:'bold',//'bold'(粗体) | 'bolder'(粗体) | 'lighter'(正常粗细) ，字体粗细
                fontFamily:'sans-serif',//'sans-serif' | 'serif' | 'monospace' | 'Arial' | 'Courier New'
                // 'Microsoft YaHei'(微软雅黑) ，文字字体
                fontSize:20,//字体大小
                lineHeight:8,//字体行高
            },
            textAlign:'auto',//整体（包括 text 和 subtext）的水平对齐
            textVerticalAlign:'auto',//整体（包括 text 和 subtext）的垂直对齐
            padding:8,//[5,10] | [ 5,6, 7, 8] ,标题内边距
            left:'auto',//'5' | '5%'，title 组件离容器左侧的距离
            right:'auto',//'title 组件离容器右侧的距离
            top:'auto',//title 组件离容器上侧的距离
            bottom:'auto',//title 组件离容器下侧的距离
        },
        tooltip: {
            textStyle: {
                fontSize: '16px',
                color: '#000' // 设置文本颜色 默认#FFF
            },
            trigger: 'axis'
        },
        toolbox: {
            feature: {
                //dataView: { show: true, readOnly: false },
                //magicType: { show: true, type: ['line', 'bar'] },
                //restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        legend: {
            textStyle:{
                color:'#15753a',
                fontSize: 14,
                fontWeight: 'bold'

            },
            data: ['生产计划', '计划完成率']
        },
        xAxis: [
            {
                type: 'category',
                data: ['7月', '8月', '9月', '10月'],
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '生产计划',
                min: 0,
                max: 1500,
                interval: 300,
                axisLabel: {
                    textStyle: {
                        color: '#ffffff'
                    },
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '计划完成率',
                min: 0,
                max: 100,
                interval: 20,
                axisLabel: {
                    textStyle: {
                        color: '#ffffff'
                    },
                    formatter: '{value}'+'%'
                }
            }
        ],
        series: [
            {
                name: '生产计划',
                type: 'bar',
                itemStyle: {
                    normal:{
                        color:'#86f9cd'
                    }
                },
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    1000, 2000, 1000, 1500
                ]
            },
            {
                name: '计划完成率',
                type: 'line',
                itemStyle: {
                    normal:{
                        color:'#eec144'
                    }
                },
                yAxisIndex: 1,
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    100, 99, 90, 98
                ]
            }
        ]
    };
    //option.xAxis.nameTextStyle.color = 'red';
    eChart.setOption(option, true);
}