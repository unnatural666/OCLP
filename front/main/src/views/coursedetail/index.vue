<template>
    <div >
      <div class="article-banner">
      <div class="banner-bg"></div>
      <div class="banner-info">
        <div class="banner-left">
          <p>课程 <span>\ 编程入门</span></p>
          <p class="tit">{{courseBase.name}}</p>
          <p class="pic"><span class="new-pic">特惠价格￥{{courseMarket.price}}</span> <span class="old-pic">原价￥{{courseMarket.price_old}}</span></p>
          <p class="info">
            <a  target="_blank" @click="nowStudy" v-if="this.now"><span >马上学习</span></a>
            <a  target="_blank" @click="nowStudy"  v-if="this.continue"><span >继续学习</span></a>
<!--            <a v-bind:href="['http://localhost:13000/#/learning/'+this.courseid+'/0']" target="_blank" >马上学习</a>-->

            <span><em>难度等级</em>中级</span>
            <span><em>课程时长</em>2小时27分</span>
            <span><em>评分</em>4.7分</span>
            <span><em>授课模式</em>录播</span>
          </p>
        </div>
        <div class="banner-rit">
          <p>
            <a href="../../test/learning/video_learning.html" target="_blank">
              <img v-bind:src="['http://192.168.137.84/'+coursePic.pic]" alt="">
<!--              <img src="../../../static/img/widget-video.png" alt="" style="position: absolute">-->
            </a>
          </p>
          <p class="vid-act"><span> <i class="i-heart"></i>收藏 23 </span> <span>分享 <i class="i-weixin"></i><i class="i-qq"></i></span></p>
        </div>
      </div>
    </div>
      <div class="article-cont">
        <div class="tit-list">
          <a href="javascript:;" id="articleClass" class="active">课程介绍</a>
          <a href="javascript:;" id="articleItem">目录</a>
          <a href="javascript:;" id="artcleAsk">问答</a>
          <a href="javascript:;" id="artcleNot">笔记</a>
          <a href="javascript:;" id="artcleCod">评价</a>
          <!--<div class="down-fill">
              <span>资料下载</span>
              <ul>
                  <li>java视频资料</li>
                  <li>java视频资料</li>
                  <li>java视频资料</li>
              </ul>
          </div>-->
        </div>
        <div class="article-box">
          <div class="articleClass" style="display: block">
            <!--<div class="rit-title">评价</div>-->
            <div class="article-cont">
              <div class="article-left-box">
                <div class="content">

                  <div class="content-com suit">
                    <div class="title"><span>适用人群</span></div>
                    <div class="cont cktop">
                      <div >
                        <p>本课程假设学生熟悉大多数入门课程所涉及的程序，但它被明确设计成不是一门特别高级的课程。</p>
                      </div>
                      <!--<span class="on-off">更多 <i class="i-chevron-bot"></i></span>-->
                    </div>
                  </div>
                  <div class="content-com course">
                    <div class="title"><span>课程制作</span></div>
                    <div class="cont">
                      <div class="img-box"><img src=../../../static/img/widget-myImg.jpg" alt=""></div>
                      <div class="info-box">
                        <p class="name">教学方：<em>XX老师</em></p>
                        <!-- <p class="lab">高级前端开发工程师 10年开发经验</p>-->
                        <p class="info">JavaEE开发与教学多年，精通JavaEE技术体系，对流行框架JQuery、DWR、Struts1/2，Hibernate，Spring，MyBatis、JBPM、Lucene等有深入研究。授课逻辑严谨，条理清晰，注重学生独立解决问题的能力。</p>
                        <!-- <p><span>难度等级</span>中级</p>
                         <p><span>课程时长</span>8-16小时/周，共4周</p>
                         <p><span>如何通过</span>通过所有的作业及考核，作业共4份，考核为一次终极考核</p>
                         <p><span>用户评分</span>平均用户评分 <em>4.9</em> <a href="#">查看全部评价</a></p>
                         <p><span>课程价格</span>特惠价格<em>￥999</em> <i> 原价1999 </i></p>-->
                      </div>
                    </div>

                  </div>
                  <div class="content-com about">
                    <div class="title"><span>课程介绍</span></div>
                    <div class="cont cktop">
                      <div >
                        <p>本课程假设学生熟悉大多数入门课程所涉及的程序，但它被明确设计成不是一门特别高级的课程。学生应该熟悉变量，条件语句，数组，链表，栈，和递归（递归算法将审查和扩展），和一个接口和实现之间的区别。学生应该渴望用新的语言编写程序。本课程C部分分析了面向对象的基本概念和对比他们的其他语言，用java或密切相关的语言如此熟悉（例如，C #）可能有助于C部分，但它是没有必要的作业。本课程是基于专为第二和第三年本科生设计的课程：不是第一个计算机科学课程，但不是一个高级课程。因此，它当然不会涵盖在编程语言的美丽世界的一切，但它是一个坚实的介绍。它的目的是大开眼界和迷人的学习者寻求“第三或第四编程课程”，并为有更多的经验，谁正在寻找一个明确和精确的编程语言基础的学习者。课程中的作业设计是具有挑战性的，但课程内容需要你所需要的一切。</p>
                      </div>
                      <!--<span class="on-off">更多 <i class="i-chevron-bot"></i></span>-->
                    </div>
                  </div>
                  <div class="content-com prob">
                    <div class="title"><span>常见问题</span></div>
                    <div class="cont">
                      <ul>
                        <li class="item"><span class="on-off"><i class="i-chevron-bot"></i> 我什么时候能够访问课程视频与作业？</span>
                          <div class="drop-down">
                            <p>课程安排灵活，课程费用支付提供180天全程准入和资格证书。自定进度课程建议的最后期限，但你不会受到惩罚错过期限，只要你赚你的证书在180天内。以会话为基础的课程可能要求你在截止日期前保持正轨，但如果你落后了，你可以切换到以后的会议，你完成的任何工作将与你转移。</p>
                          </div>
                        </li>
                        <li class="item"><span class="on-off"><i class="i-chevron-bot"></i> 如何需要额外的时间来完成课程会怎么样？</span>
                          <div class="drop-down">
                            <p>课程安排灵活，课程费用支付提供180天全程准入和资格证书。自定进度课程建议的最后期限，但你不会受到惩罚错过期限，只要你赚你的证书在180天内。以会话为基础的课程可能要求你在截止日期前保持正轨，但如果你落后了，你可以切换到以后的会议，你完成的任何工作将与你转移。</p>
                          </div>
                        </li>
                        <li class="item"><span class="on-off"><i class="i-chevron-bot"></i> 我支付次课程之后会得到什么？</span>
                          <div class="drop-down">
                            <p>课程安排灵活，课程费用支付提供180天全程准入和资格证书。自定进度课程建议的最后期限，但你不会受到惩罚错过期限，只要你赚你的证书在180天内。以会话为基础的课程可能要求你在截止日期前保持正轨，但如果你落后了，你可以切换到以后的会议，你完成的任何工作将与你转移。</p>
                          </div>
                        </li>
                        <li class="item"><span class="on-off"><i class="i-chevron-bot"></i> 退款条例是如何规定的？</span>
                          <div class="drop-down">
                            <p>课程安排灵活，课程费用支付提供180天全程准入和资格证书。自定进度课程建议的最后期限，但你不会受到惩罚错过期限，只要你赚你的证书在180天内。以会话为基础的课程可能要求你在截止日期前保持正轨，但如果你落后了，你可以切换到以后的会议，你完成的任何工作将与你转移。</p>
                          </div>
                        </li>
                        <li class="item"><span class="on-off"><i class="i-chevron-bot"></i> 有助学金？</span>
                          <div class="drop-down">
                            <p>课程安排灵活，课程费用支付提供180天全程准入和资格证书。自定进度课程建议的最后期限，但你不会受到惩罚错过期限，只要你赚你的证书在180天内。以会话为基础的课程可能要求你在截止日期前保持正轨，但如果你落后了，你可以切换到以后的会议，你完成的任何工作将与你转移。</p>
                          </div>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>

              <!--侧边栏-->
              <!--#include virtual="/include/course_detail_side.html"-->
              <!--侧边栏-->
              <div class="article-right-box">
                <div class="about-teach">
                  <div class="teach-info">
                    <!--机构logo-->
                    <img src="../../../static/img/asset-logo.png" width="40px" alt="">
                    <p>黑马程序员黑马程序员</p>
                  </div>
                  <div class="teach-info">
                    <ul class="tree-list"><li><p class="item-tt">好评度</p><span class="item-num">  93%  </span></li><li><p class="item-tt">课程数</p><span class="item-num js-item-num" data-num="39">39</span></li><li><p class="item-tt">学生数</p><span class="item-num js-item-num" data-num="364386">36万</span></li></ul>
                  </div>
                  <div class="teach-info">
                    <p><a href="#" class="courselist_link">TA的课程</a></p>
                  </div>

                  <p class="synopsis">JavaEE开发与教学多年，精通JavaEE技术体系，对流行框架JQuery、DWR、Struts1/2，Hibernate，Spring，MyBatis、JBPM、Lucene等有深入研究。授课逻辑严谨，条理清晰，注重学生独立解决问题的能力。</p>
                </div>
                <div class="learing-box">
                  <div class="tit">看过该课的同学也在看</div>
                  <div class="item-box">
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(../../../static/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Linux 达人养成记</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Linux 达人养成记</a>
                      </div>
                    </div>
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(../../../static/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Redis从入门到精通</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Redis从入门到精通</a>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="articleItem" style="display: none">
            <div class="article-cont-catalog">
              <div class="article-left-box">
                <div class="content">
                  <div class="item">
                    <div class="title act"><i class="i-chevron-top"></i>第一阶段 HTTP协议基础详解<span class="time">8小时</span></div>
                    <div class="about">使用Java消息中间件处理异步消息成为了分布式系统中的必修课，通过本门课程可以深入浅出的学习如何在Java中使用消息中间件并且一步一步打造更优雅的最佳实践方案。</div>
                    <div class="drop-down" style="height: 260px;">
                      <ul class="list-box">
                        <li class="active">1.1 阅读：分级政策细节 <span>97’33”</span></li>
                        <li>1.2 视频：为什么分为 A 部分、B 部分、C 部分 <span>66’15”</span></li>
                        <li>1.3 视频：软件安装介绍 <span>86’42”</span></li>
                        <li>1.4 阅读：Emacs安装 <span>59’00”</span></li>
                        <li>1.5 作业1：Emacs安装 <span>93’29”</span></li>
                        <li>阶段测试</li>
                      </ul>
                    </div>
                  </div>
                  <div class="item">
                    <div class="title"><i class="i-chevron-bot"></i>第二阶段 HTTP协议基础详解<span class="time">8小时</span></div>
                    <div class="about">使用Java消息中间件处理异步消息成为了分布式系统中的必修课，通过本门课程可以深入浅出的学习如何在Java中使用消息中间件并且一步一步打造更优雅的最佳实践方案。</div>
                    <div class="drop-down">
                      <ul class="list-box">
                        <li class="active">1.1 阅读：分级政策细节 <span>97’33”</span></li>
                        <li>1.2 视频：为什么分为 A 部分、B 部分、C 部分 <span>66’15”</span></li>
                        <li>1.3 视频：软件安装介绍 <span>86’42”</span></li>
                        <li>1.4 阅读：Emacs安装 <span>59’00”</span></li>
                        <li>1.5 作业1：Emacs安装 <span>93’29”</span></li>
                        <li>阶段测试</li>
                      </ul>
                    </div>
                  </div>
                  <div class="item">
                    <div class="title"><i class="i-chevron-bot"></i>第三阶段 HTTP协议基础详解<span class="time">3小时</span></div>
                    <div class="about">使用Java消息中间件处理异步消息成为了分布式系统中的必修课，通过本门课程可以深入浅出的学习如何在Java中使用消息中间件并且一步一步打造更优雅的最佳实践方案。</div>
                    <div class="drop-down">
                      <ul class="list-box">
                        <li class="active">1.1 阅读：分级政策细节 <span>97’33”</span></li>
                        <li>1.2 视频：为什么分为 A 部分、B 部分、C 部分 <span>66’15”</span></li>
                        <li>1.3 视频：软件安装介绍 <span>86’42”</span></li>
                        <li>1.4 阅读：Emacs安装 <span>59’00”</span></li>
                        <li>1.5 作业1：Emacs安装 <span>93’29”</span></li>
                        <li>阶段测试</li>
                      </ul>
                    </div>
                  </div>
                  <div class="item">
                    <div class="title"><i class="i-chevron-bot"></i>第四阶段 HTTP协议基础详解<span class="time">3小时</span></div>
                    <div class="about">使用Java消息中间件处理异步消息成为了分布式系统中的必修课，通过本门课程可以深入浅出的学习如何在Java中使用消息中间件并且一步一步打造更优雅的最佳实践方案。</div>
                    <div class="drop-down">
                      <ul class="list-box">
                        <li class="active">1.1 阅读：分级政策细节 <span>97’33”</span></li>
                        <li>1.2 视频：为什么分为 A 部分、B 部分、C 部分 <span>66’15”</span></li>
                        <li>1.3 视频：软件安装介绍 <span>86’42”</span></li>
                        <li>1.4 阅读：Emacs安装 <span>59’00”</span></li>
                        <li>1.5 作业1：Emacs安装 <span>93’29”</span></li>
                        <li>阶段测试</li>
                      </ul>
                    </div>
                  </div>
                  <div class="item">
                    <div class="title"><i class="i-chevron-bot"></i>第五阶段 HTTP协议基础详解<span class="time">3小时</span></div>
                    <div class="about">使用Java消息中间件处理异步消息成为了分布式系统中的必修课，通过本门课程可以深入浅出的学习如何在Java中使用消息中间件并且一步一步打造更优雅的最佳实践方案。</div>
                    <div class="drop-down">
                      <ul class="list-box">
                        <li class="active">1.1 阅读：分级政策细节 <span>97’33”</span></li>
                        <li>1.2 视频：为什么分为 A 部分、B 部分、C 部分 <span>66’15”</span></li>
                        <li>1.3 视频：软件安装介绍 <span>86’42”</span></li>
                        <li>1.4 阅读：Emacs安装 <span>59’00”</span></li>
                        <li>1.5 作业1：Emacs安装 <span>93’29”</span></li>
                        <li>阶段测试</li>
                      </ul>
                    </div>

                  </div>
                  <div class="item">
                    <a href="#" class="overwrite">毕业考核</a>
                  </div>
                </div>
              </div>
              <div class="article-right-box">
                <div class="about-teach">
                  <div class="teach-info">
                    <!--机构logo-->
                    <img src="../../../static/img/asset-logo.png" width="40px" alt="">
                    <p>黑马程序员黑马程序员</p>
                  </div>
                  <div class="teach-info">
                    <ul class="tree-list"><li><p class="item-tt">好评度</p><span class="item-num">  93%  </span></li><li><p class="item-tt">课程数</p><span class="item-num js-item-num" data-num="39">39</span></li><li><p class="item-tt">学生数</p><span class="item-num js-item-num" data-num="364386">36万</span></li></ul>
                  </div>
                  <div class="teach-info">
                    <p><a href="#" class="courselist_link">TA的课程</a></p>
                  </div>

                  <p class="synopsis">JavaEE开发与教学多年，精通JavaEE技术体系，对流行框架JQuery、DWR、Struts1/2，Hibernate，Spring，MyBatis、JBPM、Lucene等有深入研究。授课逻辑严谨，条理清晰，注重学生独立解决问题的能力。</p>
                </div>
                <div class="learing-box">
                  <div class="tit">看过该课的同学也在看</div>
                  <div class="item-box">
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Linux 达人养成记</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Linux 达人养成记</a>
                      </div>
                    </div>
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Redis从入门到精通</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Redis从入门到精通</a>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
              <!--侧边栏-->
              <!--#include virtual="/include/course_detail_side.html"-->
              <!--侧边栏-->
            </div>
          </div>
          <div class="artcleAsk" style="display: none">
            <div class="article-cont-ask">
              <div class="article-left-box">
                <div class="content">
                  <div class="content-title">
                    <p><a class="all">全部</a><a>精选</a><a>我的</a></p>
                    <p><a class="all">全部</a><span><a>1.1</a><a>1.2</a><a>1.3</a><a>1.4</a><a>1.5</a></span><a href="$" class="more">更多 <i class="i-chevron-bot"></i></a></p>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="../../../static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p class="title">如何用微服务重构应用程序?</p>
                      <p><span>我来回答</span></p>
                      <p>2017-3-20 <span><i></i>回答2</span><span><i></i>浏览2</span></p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="../../../static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p class="title">如何用微服务重构应用程序?</p>
                      <p>在讨论如何将重构转化为微服务之前，退后一步，仔细观察微服务的内容和时间是很重要的。以下两个要点将会对任何微服务重构策略产生重大影响。 【最新 <i class="new">心跳347890</i> 的回答】</p>
                      <p>2017-3-20 <span class="action-box"><span><i class="i-answer"></i>回答 2</span><span><i class="i-browse"></i>浏览 12</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="../../../static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p class="title">如何用微服务重构应用程序?</p>
                      <p>在讨论如何将重构转化为微服务之前，退后一步，仔细观察微服务的内容和时间是很重要的。以下两个要点将会对任何微服务重构策略产生重大影响。 【最新 <i class="new">心跳347890</i> 的回答】</p>
                      <p>2017-3-20 <span class="action-box"><span><i class="i-answer"></i>回答 2</span><span><i class="i-browse"></i>浏览 12</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="../../../static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p class="title">如何用微服务重构应用程序?</p>
                      <p>在讨论如何将重构转化为微服务之前，退后一步，仔细观察微服务的内容和时间是很重要的。以下两个要点将会对任何微服务重构策略产生重大影响。 【最新 <i class="new">心跳347890</i> 的回答】</p>
                      <p>2017-3-20 <span class="action-box"><span><i class="i-answer"></i>回答 2</span><span><i class="i-browse"></i>浏览 12</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="../../../static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p class="title">如何用微服务重构应用程序?</p>
                      <p>在讨论如何将重构转化为微服务之前，退后一步，仔细观察微服务的内容和时间是很重要的。以下两个要点将会对任何微服务重构策略产生重大影响。 【最新 <i class="new">心跳347890</i> 的回答】</p>
                      <p>2017-3-20 <span class="action-box"><span><i class="i-answer"></i>回答 2</span><span><i class="i-browse"></i>浏览 12</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="../../../static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p class="title">如何用微服务重构应用程序?</p>
                      <p>在讨论如何将重构转化为微服务之前，退后一步，仔细观察微服务的内容和时间是很重要的。以下两个要点将会对任何微服务重构策略产生重大影响。 【最新 <i class="new">心跳347890</i> 的回答】</p>
                      <p>2017-3-20 <span class="action-box"><span><i class="i-answer"></i>回答 2</span><span><i class="i-browse"></i>浏览 12</span></span>
                      </p>
                    </div>
                  </div>

                  <div class="itemlast">
                    <a href="#" class="overwrite">显示更多问题</a>
                  </div>
                </div>
              </div>
              <!--侧边栏-->
              <!--#include virtual="/include/course_detail_side.html"-->
              <div class="article-right-box">
                <div class="about-teach">
                  <div class="teach-info">
                    <!--机构logo-->
                    <img src="../../../static/img/asset-logo.png" width="40px" alt="">
                    <p>黑马程序员黑马程序员</p>
                  </div>
                  <div class="teach-info">
                    <ul class="tree-list"><li><p class="item-tt">好评度</p><span class="item-num">  93%  </span></li><li><p class="item-tt">课程数</p><span class="item-num js-item-num" data-num="39">39</span></li><li><p class="item-tt">学生数</p><span class="item-num js-item-num" data-num="364386">36万</span></li></ul>
                  </div>
                  <div class="teach-info">
                    <p><a href="#" class="courselist_link">TA的课程</a></p>
                  </div>

                  <p class="synopsis">JavaEE开发与教学多年，精通JavaEE技术体系，对流行框架JQuery、DWR、Struts1/2，Hibernate，Spring，MyBatis、JBPM、Lucene等有深入研究。授课逻辑严谨，条理清晰，注重学生独立解决问题的能力。</p>
                </div>
                <div class="learing-box">
                  <div class="tit">看过该课的同学也在看</div>
                  <div class="item-box">
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Linux 达人养成记</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Linux 达人养成记</a>
                      </div>
                    </div>
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(../../../static/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Redis从入门到精通</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Redis从入门到精通</a>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
              <!--侧边栏-->
            </div>
          </div>
          <div class="artcleNot" style="display: none;">
            <div class="article-cont-note">
              <div class="article-left-box">
                <div class="content">
                  <div class="content-title">
                    <p><a class="all">全部</a><a>精选</a><a>我的</a></p>
                    <p><a class="all">全部</a><span><a>1.1</a><a>1.2</a><a>1.3</a><a>1.4</a><a>1.5</a></span><a href="$" class="more">更多 <i class="i-chevron-bot"></i></a></p>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="/static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <span class="video-time"><i class="i-play"></i>2`10`</span>
                      <p><img src="/static/img/widget-demo.png" width="221" alt=""></p>
                      <p class="action-box">4小时前 <span class="active-box"><span><i class="i-coll"></i>采集</span><span><i class="i-laud"></i>赞</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="/static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p>在讨论如何将重构转化为微服务之前，退后一步，<br>仔细观察微服务的内容和时间是很重要的。<br>以下两个要点将会对任何微服务重构策略产生重大影响。 </p>
                      <p class="action-box">4小时前 <span class="active-box"><span><i class="i-edt"></i>编辑</span><span><i class="i-del"></i>删除</span><span><i class="i-laud"></i>赞</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="/static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p>在讨论如何将重构转化为微服务之前，退后一步，<br>仔细观察微服务的内容和时间是很重要的。<br>以下两个要点将会对任何微服务重构策略产生重大影响。 </p>
                      <p class="action-box">4小时前 <span class="active-box"><span><i class="i-edt"></i>编辑</span><span><i class="i-del"></i>删除</span><span><i class="i-laud"></i>赞</span></span>
                      </p>
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-left">
                      <p><img src="/static/img/widget-myImg.jpg" width="60px" alt=""></p>
                      <p>毛老师</p>
                    </div>
                    <div class="item-right">
                      <p>在讨论如何将重构转化为微服务之前，退后一步，<br>仔细观察微服务的内容和时间是很重要的。<br>以下两个要点将会对任何微服务重构策略产生重大影响。 </p>
                      <p class="action-box">4小时前 <span class="active-box"><span><i class="i-edt"></i>编辑</span><span><i class="i-del"></i>删除</span><span><i class="i-laud"></i>赞</span></span>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
              <div class="article-right-box">
                <div class="about-teach">
                  <div class="teach-info">
                    <!--机构logo-->
                    <img src="../../../static/img/asset-logo.png" width="40px" alt="">
                    <p>黑马程序员黑马程序员</p>
                  </div>
                  <div class="teach-info">
                    <ul class="tree-list"><li><p class="item-tt">好评度</p><span class="item-num">  93%  </span></li><li><p class="item-tt">课程数</p><span class="item-num js-item-num" data-num="39">39</span></li><li><p class="item-tt">学生数</p><span class="item-num js-item-num" data-num="364386">36万</span></li></ul>
                  </div>
                  <div class="teach-info">
                    <p><a href="#" class="courselist_link">TA的课程</a></p>
                  </div>

                  <p class="synopsis">JavaEE开发与教学多年，精通JavaEE技术体系，对流行框架JQuery、DWR、Struts1/2，Hibernate，Spring，MyBatis、JBPM、Lucene等有深入研究。授课逻辑严谨，条理清晰，注重学生独立解决问题的能力。</p>
                </div>
                <div class="learing-box">
                  <div class="tit">看过该课的同学也在看</div>
                  <div class="item-box">
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Linux 达人养成记</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Linux 达人养成记</a>
                      </div>
                    </div>
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Redis从入门到精通</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Redis从入门到精通</a>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
              <!--侧边栏-->
              <!--#include virtual="/include/course_detail_side.html"-->
              <!--侧边栏-->
            </div>
          </div>
          <div class="artcleCod" style="display: none;">
            <div class="article-cont">
              <div class="article-left-box">
                <div class="comment-box">
                  <div class="evaluate">
                    <div class="eva-top">
                      <div class="tit">课程评分 </div>
                      <div class="star">
                        <div class="score"><i>5</i></div>
                      </div><span class="star-score"> <i>5</i> 分</span></div>
                    <div class="eva-cont">
                      <div class="tit">学员评语 </div>
                      <div class="text-box">
                        <textarea class="form-control" rows="5" placeholder="扯淡、吐槽、表扬、鼓励......想说啥说啥！"></textarea>
                        <div class="text-right"><span>发表评论</span></div>
                      </div>
                    </div>
                  </div>
                  <div class="course-evaluate">
                    <div class="top-tit">评论
                      <span>
                        <label><input name="eval" type="radio" value="" checked /> 所有学生 </label>
                        <label><input name="eval" type="radio" value="" /> 完成者 </label>
                    </span>
                    </div>
                    <div class="top-cont">
                      <div class="cont-top-left">
                        <div class="star-scor">
                          <div class="star-show">
                            <div class="score"><i>5</i></div>
                          </div>
                          <div class="scor">4.9分</div>
                        </div>
                        <div class="all-scor">总评分：12343</div>
                      </div>
                      <div class="cont-top-right">
                        <div class="star-grade">五星
                          <div class="grade">
                            <div class="grade-percent"><span></span></div>
                            <div class="percent-num"><i>95</i>%</div>
                          </div>
                        </div>
                        <div class="star-grade">四星
                          <div class="grade">
                            <div class="grade-percent"><span></span></div>
                            <div class="percent-num"><i>5</i>%</div>
                          </div>
                        </div>
                        <div class="star-grade">三星
                          <div class="grade">
                            <div class="grade-percent"><span></span></div>
                            <div class="percent-num"><i>0</i>%</div>
                          </div>
                        </div>
                        <div class="star-grade">二星
                          <div class="grade">
                            <div class="grade-percent"><span></span></div>
                            <div class="percent-num"><i>2</i>%</div>
                          </div>
                        </div>
                        <div class="star-grade">一星
                          <div class="grade">
                            <div class="grade-percent"><span></span></div>
                            <div class="percent-num"><i>1</i>%</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="comment-item-box">
                      <div class="title">评论 <span>12453条评论</span></div>
                      <div class="item">
                        <div class="item-left">
                          <p><img src="/static/img/widget-pic.png" width="60px" alt=""></p>
                          <p>毛老师</p>
                        </div>
                        <div class="item-cent">
                          <p>很受用，如果再深入下就更好了。虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！</p>
                          <p class="time">2017-2-43</p>
                        </div>
                        <div class="item-rit">
                          <p>
                          <div class="star-show">
                            <div class="score"><i>4</i></div>
                          </div>
                          </p>
                          <p>评分 <span>5星</span></p>
                        </div>
                      </div>
                      <div class="item">
                        <div class="item-left">
                          <p><img src="/static/img/widget-pic.png" width="60px" alt=""></p>
                          <p>毛老师</p>
                        </div>
                        <div class="item-cent">
                          <p>很受用，如果再深入下就更好了。虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！</p>
                          <p class="time">2017-2-43</p>
                        </div>
                        <div class="item-rit">
                          <p>
                          <div class="star-show">
                            <div class="score"><i>5</i></div>
                          </div>
                          </p>
                          <p>评分 <span>5星</span></p>
                        </div>
                      </div>
                      <div class="item">
                        <div class="item-left">
                          <p><img src="/static/img/widget-pic.png" width="60px" alt=""></p>
                          <p>毛老师</p>
                        </div>
                        <div class="item-cent">
                          <p>很受用，如果再深入下就更好了。虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！</p>
                          <p class="time">2017-2-43</p>
                        </div>
                        <div class="item-rit">
                          <p>
                          <div class="star-show">
                            <div class="score"><i>5</i></div>
                          </div>
                          </p>
                          <p>评分 <span>5星</span></p>
                        </div>
                      </div>
                      <div class="item">
                        <div class="item-left">
                          <p><img src="/static/img/widget-pic.png" width="60px" alt=""></p>
                          <p>毛老师</p>
                        </div>
                        <div class="item-cent">
                          <p>很受用，如果再深入下就更好了。虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！虽然都是入门级别的，但是也很使用，后续就需要自己发挥了！</p>
                          <p class="time">2017-2-43</p>
                        </div>
                        <div class="item-rit">
                          <p>
                          <div class="star-show">
                            <div class="score"><i>5</i></div>
                          </div>
                          </p>
                          <p>评分 <span>5星</span></p>
                        </div>
                      </div>
                      <div class="get-more">页面加载中...</div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="article-right-box">
                <div class="about-teach">
                  <div class="teach-info">
                    <!--机构logo-->
                    <img src="../../../static/img/asset-logo.png" width="40px" alt="">
                    <p>黑马程序员黑马程序员</p>
                  </div>
                  <div class="teach-info">
                    <ul class="tree-list"><li><p class="item-tt">好评度</p><span class="item-num">  93%  </span></li><li><p class="item-tt">课程数</p><span class="item-num js-item-num" data-num="39">39</span></li><li><p class="item-tt">学生数</p><span class="item-num js-item-num" data-num="364386">36万</span></li></ul>
                  </div>
                  <div class="teach-info">
                    <p><a href="#" class="courselist_link">TA的课程</a></p>
                  </div>

                  <p class="synopsis">JavaEE开发与教学多年，精通JavaEE技术体系，对流行框架JQuery、DWR、Struts1/2，Hibernate，Spring，MyBatis、JBPM、Lucene等有深入研究。授课逻辑严谨，条理清晰，注重学生独立解决问题的能力。</p>
                </div>
                <div class="learing-box">
                  <div class="tit">看过该课的同学也在看</div>
                  <div class="item-box">
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Linux 达人养成记</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Linux 达人养成记</a>
                      </div>
                    </div>
                    <div class="item-list hov" >
                      <div class="infobox">
                        <div class="morebox" style="background: url(/img/widget-titBg.png) no-repeat;">

                          <p class="top-tit"><a href="">Redis从入门到精通</a></p>
                          <p class="top-lab">传智播客</p>
                          <p class="top-num">2589646次播放<span>4.8分</span></p>

                        </div>
                        <a>Redis从入门到精通</a>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
              <!--侧边栏-->
              <!--#include virtual="/include/course_detail_side.html"-->
              <!--侧边栏-->
            </div>
          </div>
        </div>
      </div>
    </div>

</template>

<script>
  // import $ from  "../../../static/plugins/jquery/dist/jquery.js"
 import $ from "jquery"
  import * as courseApi from "../allcourse/api/course";
  import {course_view} from "../allcourse/api/course";

  $('.vid-act').click(function() {
    $(this).find('.i-heart').css('background-position', '4px -55px')

  })

  $(function() {
    //点击下拉
    //用法：HTML 点击事件为more,父级使用overflow：hidden；限定高 more与要展开的内容为同级 要展开内容添加 drop-down的class
    function ckMove(target, ckgar, het, text, incr) {
      var inc = incr ? incr : 0;
      $(target).find(ckgar).on('click', function() {
        var h = $(this).parent().find('.drop-down ul').height();
        if (!$(this).hasClass('act')) {
          $(this).addClass('act');
          $(this).parent().find('.drop-down').css({
            'height': (h + inc) + 'px'
          });
          $(this).find('i').removeClass('i-chevron-bot').addClass('i-chevron-top')
        } else {
          $(this).removeClass('act');
          $(this).parent().find('.drop-down').css({
            'height': het + 'px'
          });
          $(this).find('i').removeClass('i-chevron-top').addClass('i-chevron-bot')
        }
      })
    }
    //章节收缩
    ckMove('.article-cont .article-left-box', '.title', 0);

    /* $('.learing-box .item-list').mouseover(function(e) {
         $(this).css({
             'height': '140px'
         }).addClass('hov').siblings().css({
             'height': '50px'
         })
         $(this).siblings().removeClass('hov')
     })
     $('.learing-box .item-box').mouseout(function() {
         $(this).find('.item-list:first').css({
             'height': '140px'
         }).addClass('hov')
         $(this).find('.item-list:first').siblings().css({
             'height': '50px'
         }).removeClass('hov')
     })*/
  })

  $(function() {
    $('.active-box span').click(function() {
      $(this).css({
        'color': '#00a4ff'
      })
      if ($(this).find('i').hasClass('i-laud')) {
        $(this).find('.i-laud').css('background-position', '-80px -19px')
      } else if ($(this).find('i').hasClass('i-coll')) {
        $(this).find('.i-coll').css('background-position', '1px -75px')
      }
    })
    /*$('.learing-box .item-list').mouseover(function(e) {
        $(this).css({
            'height': '140px'
        }).addClass('hov').siblings().css({
            'height': '50px'
        })
        $(this).siblings().removeClass('hov')
    })
    $('.learing-box .item-box').mouseout(function() {
        $(this).find('.item-list:first').css({
            'height': '140px'
        }).addClass('hov')
        $(this).find('.item-list:first').siblings().css({
            'height': '50px'
        }).removeClass('hov')
    })*/
  })


  $(function() {
    //评分
    $('.star .score').map(function(n, i) {
      var x = Number($(this).find('i').text());
      var w = 109 * (1 - x / 5);
      $(this).css('width', w + 'px');
    })
    //评论打分
    $('.evaluate .star').mousemove(function(e) {
      var startX = $(this).offset().left;
      var movX = e.clientX - startX + 0.5;
      var w = 145 * (1 - movX / 145);
      $(this).find('.score').css('width', w + 'px');
      $('.star-score i').text((movX / 145 * 5).toFixed(1))
    })
    //星级评分
    $('.grade').map(function(n, i) {
      var pret = $(this).find('.percent-num i').text();
      var wt = $(this).find('.grade-percent').width();
      $(this).find('.grade-percent span').css('width', wt * pret / 100);
    })



  })


  $(function() {
    //点击下拉
    function ckMove(target, het, text, incr) {
      var inc = incr ? incr : 0;
      $(target).find('.on-off').on('click', function() {
        var h = $(this).parent().find('.drop-down p').height();
        if (!$(this).hasClass('act')) {
          $(this).addClass('act');
          $(this).parent().find('.drop-down').css({
            'height': (h + inc) + 'px'
          });
          $(this).find('i').removeClass('i-chevron-bot').addClass('i-chevron-top')
        } else {
          $(this).removeClass('act');
          $(this).parent().find('.drop-down').css({
            'height': het + 'px'
          });
          $(this).find('i').removeClass('i-chevron-top').addClass('i-chevron-bot')
        }
      })
    }
    ckMove('.cktop', 60);
    ckMove('.cont .item', 0);
    //点击关闭弹窗
    $('.close-popup').click(function() {
      $('.popup-box').hide();
    })
    $('.tit-list a').click(function() {
      $(this).addClass('active').siblings().removeClass('active');
      var clasNod = '.' + $(this)[0].id
      $(clasNod).show().siblings().hide()
    })
    // 资料下载
    $('.down-fill span').click(function() {
      $('.down-fill ul').css({
        display: 'block'
      });
    })
    $('.down-fill ul li').click(function() {
      $('.down-fill ul').css({
        display: 'none'
      });
    })
  })


    export default {
        name: "",
        data() {
         return {
           now:true,
           choosecode:'',
           continue:false,


           chooseCourse:{
             courseId:'',
             userId:'',
           },
          activeIndex:'2',
          courseid:'',
           //课程计划渲染
           courseBase:{
             name:'',

           },
           coursePic:{
             pic:'',

           },
           courseMarket:{

           },
           teachplanNode:{

           },

           teachplanList : [{
             id: 1,
             pname: '一级 1',
             children: [{
               id: 4,
               pname: '二级 1-1',
               children: [{
                 id: 9,
                 pname: '三级 1-1-1'
               }, {
                 id: 10,
                 pname: '三级 1-1-2'
               }]
             }]
           }],

        }
        },
        methods:{
          nowStudy(){
            if(this.choosecode=='1101'){
              this.$message({message: '请先登录哦！ ',type: 'warning',showClose: true});
              this.$router.push('/login')
            }else if(this.choosecode=='1102'){
              // 正式选课
              courseApi.myChoose(this.chooseCourse).then(res=>{
                console.log(res)
                window.open('http://localhost:13000/#/learning/'+this.courseid+'/0')
              })
            }else{
              window.open('http://localhost:13000/#/learning/'+this.courseid+'/0')
            }


          }
        },
        mounted(){
          this.courseid = this.$route.params.courseid
          console.log(this.courseid)
          let myName=JSON.parse(sessionStorage.getItem("activeUser"));
          console.log('判断按钮来了、、、、、、、、')
          console.log(myName)
          if(myName!=null){
            this.chooseCourse.userId=myName.userid

          }else {
            this.chooseCourse.userId=myName
          }

          this.chooseCourse.courseId = this.courseid

          courseApi.myStatus(this.chooseCourse).then((res)=>{

            console.log(res)
            if(res && res.courseBase){
              //获取课程状态
              this.teachplanList=res.teachplanNode.children
              this.teachplanNode=res.teachplanNode
              this.courseBase=res.courseBase
              this.courseMarket=res.courseMarket
              this.coursePic=res.coursePic

              //判断按钮类型
              this.choosecode=res.choosecode
              if(this.choosecode=='1101'||this.choosecode=='1102'){
                this.now=true
              }else{
                this.continue=true
                this.now=false

              }
            }
          })


          // this.courseid = this.$route.params.courseid
          // console.log("courseid=" + this.courseid)
          // courseApi.findCourseView(this.courseid).then(res=>{
          //   if(res && res.courseBase){
          //     //获取课程状态
          //     console.log('sssssssssssssssssssssssssssssssssssssssssssssssssss')
          //     console.log(res)
          //     console.log(res.courseBase)
          //     console.log(res.teachplanNode.children)
          //     this.teachplanList=res.teachplanNode.children
          //     this.teachplanNode=res.teachplanNode
          //     this.courseBase=res.courseBase
          //     this.courseMarket=res.courseMarket
          //     this.coursePic=res.coursePic
          //   }
          //
          // })

        },
        created:{

        }




    }
</script>

<style lang="scss" scoped>
 @import "../../../static/css/page-learing-index.css";
  @import "../../../static/plugins/bootstrap/dist/css/bootstrap.css";
  @import "../../../static/css/page-learing-article.css";
  @import "../../../static/css/page-learing-index.css";
 .article-banner .banner-bg {
   width: 100%;
   height: 240px;
   background: url(../../../static/img/widget-bannerBg.png) top center no-repeat;
   background-size: cover;
 }
</style>
