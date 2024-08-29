//饼图
function createNewClient(newClientPie, cockpitData) {
    let option = {
        tooltip: {
            trigger: 'item'
        },
        //grid: { top: '18%', left: '10%', right: '6%', bottom: '25%'},
        legend: {
            top: '2%',
            left: '0%',
            width: '1%',
            textStyle:{
                color:'#FFFFFF',
                fontSize: '1vw',
            }
        },
        series: [
            {
                name: '客户数量',
                type: 'pie',
                radius: ['20%', '90%'],
                selectedMode: 'single',
                label: {
                    show: true,
                    normal: {
                        color: '#FFF',
                        position: 'inner',
                        formatter: '{c} ({d}%)',
                    }
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: 12,
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: [
                    { value: 0, name: '新客户', selected:true },
                    { value: 0, name: '老客户' }
                ],
                color: ['#2DB1EF', '#2fffa4'],
            }
        ]
    };
    option.series[0].data[0].value = cockpitData.cockpit001;
    option.series[0].data[1].value = cockpitData.cockpit002;
    newClientPie.setOption(option, true);
}