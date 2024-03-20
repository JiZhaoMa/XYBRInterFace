function createfaHuoNumPie(eChart1, res) {
    let option1 = {
        title:{
            text:"发货量",
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
                //magicType: { show: true, type: ['bar', 'bar', 'bar', 'line'] },
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
            data: ['A产品', 'B产品', 'C产品', '总量']
        },
        xAxis: [
            {
                type: 'category',
                data: ['4月', '5月', '6月', '7月', '8月', '9月'],
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
                name: '总量',
                min: 0,
                max: 15000,
                interval: 3000,
                axisLabel: {
                    textStyle: {
                        color: '#ffffff'
                    },
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name: 'A产品',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    1000, 2000, 2000, 3000, 2000, 4000
                ]
            },
            {
                name: 'B产品',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    2000, 4000, 5000, 4000, 3000, 4000
                ]
            },
            {
                name: 'C产品',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [
                    3000, 4500, 5400, 4100, 3200, 4000
                ]
            },
            {
                name: '总量',
                type: 'line',
                yAxisIndex: 1,
                tooltip: {
                    valueFormatter: function (value) {
                        return value;
                    }
                },
                data: [10000, 12000, 9800, 10100, 14000, 9000]
            }
        ],
        dataZoom : [
            {
                orient: 'horizontal',
                show: true,//控制滚动条显示隐藏
                realtime: true, //拖动滚动条时是否动态的更新图表数据
                height: 5, //滚动条高度
                start: 0, //滚动条开始位置（共6等份）
                end: this.endValue,//滚动条结束位置
                top: '95%',
                bottom: '4%',
                zoomLock: false, //指定是否锁定缩放比例。
                startValue: 0, // 从头开始。
                endValue: 3,// 一次性展示4个
                showDetail: false, // 关闭滚动条提示
                fillerColor: 'rgba(255, 255, 255,0.5)',
            },
            {
                type: 'inside',
                brushSelect: true,
                start: 0,
                end: 6,
                xAxisIndex: [0],
                moveOnMouseMove: true,//是否只平移不缩放
                zoomLock: true,// 鼠标移动触发窗口平移
                zoomOnMouseWheel: false,//鼠标移动能触发窗口缩放
            },
        ]
    };
    eChart1.setOption(option1, true);
}