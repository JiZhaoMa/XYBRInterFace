function createProductOfMonthChart(eChart1, res) {
    let option1 = {
        title:{
            text:"计划完成率",
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
                //magicType: { show: true, type: ['bar', 'line', 'bar'] },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        legend: {
            textStyle:{
                color:'#15753a',
                fontSize: 14,
                fontWeight: 'bold'

            },
            data: ['生产计划', '实际完成', '实际完成率']
        },
        xAxis: [
            {
                type: 'category',
                data: ['A产品', 'B产品', 'C产品', 'D产品', 'E产品'],
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
                name: '数量',
                min: 0,
                max: 10000,
                interval: 2000,
                axisLabel: {
                    textStyle: {
                        color: '#ffffff'
                    },
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '实际完成率',
                min: 0,
                max: 100,
                interval: 20,
                axisLabel: {
                    textStyle: {
                        color: '#ffffff'
                    },
                    formatter: '{value}%'
                }
            }
        ],
        series: [
            {
                name: '生产计划',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    5000, 6000, 3000, 5000, 2000
                ]
            },
            {
                name: '实际完成',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    4560, 5700, 3000, 4000, 2000
                ]
            },
            {
                name: '实际完成率',
                type: 'line',
                yAxisIndex: 1,
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [4560/5000*100, 5700/6000*100, 3000/3000*100, 4000/5000*100, 2000/2000*100]
            }
        ],
        dataZoom : [
            {
                orient: 'horizontal',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 0, //滚动条高度
                start: 0, //滚动条开始位置（共6等份）
                end: this.endValue,//滚动条结束位置
                top: '95%',
                bottom: '4%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 4,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            },
            {
                type: 'inside',
                brushSelect: true,
                start: 0,
                end: 4,
                xAxisIndex: [0],
                moveOnMouseMove: true,//是否只平移不缩放
                zoomLock: true,// 鼠标移动触发窗口平移
                zoomOnMouseWheel: false,//鼠标移动能触发窗口缩放
            },
        ]
    };
    eChart1.setOption(option1, true);
}