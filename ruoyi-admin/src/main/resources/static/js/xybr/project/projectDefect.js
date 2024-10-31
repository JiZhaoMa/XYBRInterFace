//饼图
function createProjectDefect(bar,project) {
    option = {
        tooltip: {
            trigger: "axis",
            axisPointer: {
                // 坐标轴指示器，坐标轴触发有效
                type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            right: "4%",
            top: "15%",
            bottom: '3%',
            containLabel: true
        },
        legend: {
            right: '1%',
            data: [
                { name: "测试问题", icon: "circle" },
                { name: "试制问题", icon: "circle" },
                { name: "自测问题", icon: "circle" }
            ],
            // 大小 和位置 文字样式
            itemGap: nowSize(6),
            textStyle: {
                fontSize: nowSize(10),
                color: "#5D6C8E",
                fontFamily: "SourceHanSansCN-Regular"
            }
        },
        xAxis: [
            {
                type: "value",
                axisPointer: {
                    type: "shadow"
                },
                // 横坐标 分割线等取消显示
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                },
                splitLine: {
                    show: false
                },
                axisLabel: {
                    show: false
                }
            }
        ],
        yAxis: [
            {
                type: "category",
                // 纵坐标数据
                data: [
                    "单板",
                    "初样",
                    "正样",
                    "中试"
                ],
                yAxisIndex: 0,
                // 横坐标 分割线等取消显示
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                }
            }
        ],
        series: [
            {
                name: "测试问题",
                type: "bar",
                // 宽度
                barWidth: nowSize(10),
                barGap: '80%',
                barCategoryGap: '80%',
                // 堆叠
                stack: "总量",
                showBackground: true,
                // 全部背景
                backgroundStyle: {
                    color: "#EEF2F9"
                },
                data: [10, 11, 6, 8],
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(10)
                        },
                        color: new echarts.graphic.LinearGradient(
                            0,
                            0,
                            1,
                            0,
                            [
                                {
                                    offset: 0,
                                    color: "#FFF0A0"
                                },
                                {
                                    offset: 1,
                                    color: "#FFD355"
                                }
                            ],
                            false
                        )
                    }
                }
            },
            {
                name: "试制问题",
                type: "bar",
                // 宽度
                barWidth: nowSize(10),
                barGap: '80%',
                barCategoryGap: '80%',
                // 堆叠
                stack: "总量",
                showBackground: true,
                // 全部背景
                backgroundStyle: {
                    color: "#EEF2F9"
                },
                data: [10, 11, 6, 8],
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(10)
                        },
                        color: new echarts.graphic.LinearGradient(
                            0,
                            0,
                            1,
                            0,
                            [
                                {
                                    offset: 0,
                                    color: "#FFABAC"
                                },
                                {
                                    offset: 1,
                                    color: "#FF6772"
                                }
                            ],
                            false
                        )
                    }
                }
            },
            {
                name: "自测问题",
                type: "bar",
                // 宽度
                barWidth: nowSize(10),
                barGap: '80%',
                barCategoryGap: '80%',
                // 堆叠
                stack: "总量",
                showBackground: true,
                // 全部背景
                backgroundStyle: {
                    color: "#EEF2F9"
                },
                data: [10, 11, 6, 8],
                itemStyle: {
                    normal: {
                        show: true,
                        textStyle: {
                            fontSize: nowSize(10)
                        },
                        color: new echarts.graphic.LinearGradient(
                            0,
                            0,
                            1,
                            0,
                            [
                                {
                                    offset: 0,
                                    color: "#90BEFF"
                                },
                                {
                                    offset: 1,
                                    color: "#5EA1FF"
                                }
                            ],
                            false
                        )
                    }
                }
            }
        ]
    };
    bar.setOption(option,true);
    function nowSize(size){
        let nowClientWidth = size*(document.documentElement.clientWidth/1698);
        return nowClientWidth;
    }
}