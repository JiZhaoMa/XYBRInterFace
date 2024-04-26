//饼图
function createFaHuoPie(faHuoPie, agent) {
    let echartsCumNum = 0;
    let option = {
        title:{
            text: '发货总量',
            subtext: '',
            x:'42%',
            y:'42%',
            textStyle:{
                color:'#ffffff',//'red'，字体颜色
                fontStyle:'normal',//'italic'(倾斜) | 'oblique'(倾斜体) ，字体风格
                fontWeight:'bold',//'bold'(粗体) | 'bolder'(粗体) | 'lighter'(正常粗细) ，字体粗细
                fontFamily:'sans-serif',//'sans-serif' | 'serif' | 'monospace' | 'Arial' | 'Courier New'
                // 'Microsoft YaHei'(微软雅黑) ，文字字体
                fontSize:20,//字体大小
                lineHeight:20,//字体行高
            },
            subtextStyle:{
                color:'#ffffff',//'red'，字体颜色
                fontStyle:'normal',//'italic'(倾斜) | 'oblique'(倾斜体) ，字体风格
                fontWeight:'bold',//'bold'(粗体) | 'bolder'(粗体) | 'lighter'(正常粗细) ，字体粗细
                fontFamily:'sans-serif',//'sans-serif' | 'serif' | 'monospace' | 'Arial' | 'Courier New'
                fontSize:16,//字体大小
                lineHeight:16,//字体行高
            },
        },
        tooltip: {
            trigger: 'item',
            textStyle: {
                fontSize: '16px',
                color: '#000' // 设置文本颜色 默认#FFF
            },
            formatter: '{a}{b} : {c}个 ({d}%)',
        },
        toolbox: {
            feature: {
                //dataView: { show: true, readOnly: false },
                //magicType: { show: true, type: ['line', 'bar'] },
                //restore: { show: true },
                /*saveAsImage: { show: true }*/
            }
        },
        legend: {
            orient: 'vertical',
            right: '0',
            position: ['80%','80%'],
            textStyle: {
                color:'#FFFFFF',
                fontSize: 16,
                fontWeight: 'bold'
            }
        },
        series: [
            {
                name: '发货量',
                type: 'pie',
                radius: ['40%','60%'],
                center: ['50%','50%'],
                label: {
                    normal: {
                        show: true, //数据显示
                        formatter: '{b} : {c}'+ '\n' + '{d}%',
                        textStyle: {
                            fontWeight: 'bold',
                            color: '#FFFFFF',
                            fontSize: '16px'
                        }
                    }
                },
                data: [
                    { value: 0, name: '' },
                    { value: 0, name: '' },
                    { value: 0, name: '' }
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
    option.series[0].data.forEach(v => {
        if(v.value != null){
            echartsCumNum += parseInt(v.value)
        }
    });
    option.title.subtext = echartsCumNum;
    faHuoPie.setOption(option, true);

    let echartsArr = []; //点击图例后所剩的数据名
    let echartsNum = 0;//点击图例后所剩的数据的总和
    faHuoPie.on('legendselectchanged', (params) => {
        echartsArr = [];//将点击后的数组设为空（每点击一次就重新判断添加）
        // 循环点击图例后获取到的名字
        for (let key in params.selected) {
            // 判断值是否为true 将值为true的名字push到echartsArr数组当中保留起来
            if (params.selected[key]) {
                echartsArr.push(key)
            }
        }
        echartsCumNum = 0; //将总数的值设为0（每点击一次就重新计算）
        // 循环判断数据的全部数据里的name值是否与我们点击图例后所剩数据的数组相等
        // 相等的话就将其value值进行相加得出点击图例后所剩数据的总数
        option.series[0].data.forEach(item => {
            echartsArr.forEach(v => {
                if (item.name === v) {
                    if(item.value != null){
                        echartsCumNum += parseInt(item.value)
                    }
                }
            })
        })
        option.title.subtext = echartsCumNum //最后将其赋值给主标题即可
        faHuoPie.setOption(option);
    });

    $.ajax({
        type: "GET",
        url: urls + "report/plan/getShippingData",
        contentType: "application/json;charset=utf-8",
        data: {
            "agent": agent
        },
        dateType: "json",
        success: function (data) {
            option.series[0].data[0].value = data.mmap.shippingDataNumFirst;
            option.series[0].data[0].name = data.mmap.shippingFirstSerise;
            option.series[0].data[1].value = data.mmap.shippingDataNumSecond;
            option.series[0].data[1].name = data.mmap.shippingSecondSerise;
            option.series[0].data[2].value = data.mmap.shippingDataNumThird;
            option.series[0].data[2].name = data.mmap.shippingThirdSerise;
            option.series[0].data.forEach(v => {
                if(v.value != null){
                    echartsCumNum += parseInt(v.value);
                }
            });
            option.title.subtext = echartsCumNum;
            faHuoPie.setOption(option, true);
        },
        error: function (data) {
            alert("失败");
        }

    });
}