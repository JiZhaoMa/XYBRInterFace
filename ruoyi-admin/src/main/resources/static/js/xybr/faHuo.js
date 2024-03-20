//饼图
function createFaHuoPie(faHuoPie, res) {
    let option = {
        title:{
            text: '发货',
            textStyle:{
                color:'#ffffff',//'red'，字体颜色
                fontStyle:'normal',//'italic'(倾斜) | 'oblique'(倾斜体) ，字体风格
                fontWeight:'bold',//'bold'(粗体) | 'bolder'(粗体) | 'lighter'(正常粗细) ，字体粗细
                fontFamily:'sans-serif',//'sans-serif' | 'serif' | 'monospace' | 'Arial' | 'Courier New'
                // 'Microsoft YaHei'(微软雅黑) ，文字字体
                fontSize:20,//字体大小
                lineHeight:20,//字体行高
            },
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            textStyle: {
                fontSize: '16px',
                color: '#000' // 设置文本颜色 默认#FFF
            },
            formatter: '{a}{b} : {c}个 ({d}%)'
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
            orient: 'vertical',
            left: 'left',
            textStyle: {
                color:'#15753a',
                fontSize: 14,
                fontWeight: 'bold'
            }
        },
        series: [
            {
                name: '发货量',
                type: 'pie',
                radius: '75%',
                data: [
                    { value: 1048, name: 'A产品' },
                    { value: 735, name: 'B产品' },
                    { value: 580, name: 'C产品' }
                ],
                color: ['#7EC0EE', '#FF9F7F', '#FFD700'],//饼图区域的颜色
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    //option.series[0].label.formatter = '{b}: {c} ({d}%)\ntotal:' + 1000;
    faHuoPie.setOption(option, true);
}