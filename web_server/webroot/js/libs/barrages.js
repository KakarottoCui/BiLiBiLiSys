/* created at 2018/4/20 by BlueSky @cilicili */

/*!
** by zhangxinxu(.com)
** 与HTML5 video视频真实交互的弹幕效果
** http://www.zhangxinxu.com/wordpress/?p=6386
** MIT License
** 保留版权申明
*/

const CanvasBarrage = function (canvas, video, options) {
  if (!canvas || !video) {
    return;
  }
  const defaults = {
    opacity: 100,
    fontSize: 24,
    speed: 2,
    range: [0, 1],
    color: 'white',
    data: []
  };
  
  options = options || {};
  
  const params = {};
  
  // 参数合并
  for (let key in defaults) {
    if (options[key]) {
      params[key] = options[key];
    } else {
      params[key] = defaults[key];
    }
    this[key] = params[key];
  }
  const top = this;
  const data = top.data;
  
  if (!data || !data.length) {
    return;
  }
  
  const context = canvas.getContext('2d');
  canvas.width = canvas.clientWidth;
  canvas.height = canvas.clientHeight;
  
  // 存储实例
  const store = {};
  
  // 暂停与否
  let isPause = true;
  
  // 播放时长
  let time = video.currentTime;
  
  // 字号大小
  const fontSize = 28;
  
  // 实例方法
  const Barrage = function (obj) {
    // 一些变量参数
    this.value = obj.value;
    this.time = obj.time;
    // data中的可以覆盖全局的设置
    this.init = function () {
      // 1. 速度
      let speed = top.speed;
      if (obj.hasOwnProperty('speed')) {
        speed = obj.speed;
      }
      if (speed !== 0) {
        // 随着字数不同，速度会有微调
        speed = speed + obj.value.length / 100;
      }
      // 2. 字号大小
      const fontSize = obj.fontSize || top.fontSize;
      
      // 3. 文字颜色
      let color = obj.color || top.color;
      // 转换成rgb颜色
      color = (function () {
        const div = document.createElement('div');
        div.style.backgroundColor = color;
        document.body.appendChild(div);
        const c = window.getComputedStyle(div).backgroundColor;
        document.body.removeChild(div);
        return c;
      })();
      
      // 4. range范围
      const range = obj.range || top.range;
      // 5. 透明度
      let opacity = obj.opacity || top.opacity;
      opacity = opacity / 100;
      
      // 计算出内容长度
      const span = document.createElement('span');
      span.style.position = 'absolute';
      span.style.whiteSpace = 'nowrap';
      span.style.font = 'bold ' + fontSize + 'px "microsoft yahei", sans-serif';
      span.innerText = obj.value;
      span.textContent = obj.value;
      document.body.appendChild(span);
      // 求得文字内容宽度
      this.width = span.clientWidth;
      // 移除dom元素
      document.body.removeChild(span);
      
      // 初始水平位置和垂直位置
      this.x = canvas.width;
      if (speed === 0) {
        this.x = (this.x - this.width) / 2;
      }
      this.actualX = canvas.width;
      this.y = range[0] * canvas.height + (range[1] - range[0]) * canvas.height * Math.random();
      if (this.y < fontSize) {
        this.y = fontSize;
      } else if (this.y > canvas.height - fontSize) {
        this.y = canvas.height - fontSize;
      }
      
      this.moveX = speed;
      this.opacity = opacity;
      this.color = color;
      this.range = range;
      this.fontSize = fontSize;
    };
    
    this.draw = function () {
      // 根据此时x位置绘制文本
      context.shadowColor = 'rgba(0,0,0,' + this.opacity + ')';
      context.shadowBlur = 2;
      context.font = this.fontSize + 'px "microsoft yahei", sans-serif';
      if (/rgb\(/.test(this.color)) {
        context.fillStyle = 'rgba(' + this.color.split('(')[1].split(')')[0] + ',' + this.opacity + ')';
      } else {
        context.fillStyle = this.color;
      }
      // 填色
      context.fillText(this.value, this.x, this.y);
    };
  };
  
  data.forEach(function (obj, index) {
    store[index] = new Barrage(obj);
  });
  
  // 绘制弹幕文本
  const draw = function () {
    for (let index in store) {
      const barrage = store[index];
      
      if (barrage && !barrage.disabled && time >= barrage.time) {
        if (!barrage.inited) {
          barrage.init();
          barrage.inited = true;
        }
        barrage.x -= barrage.moveX;
        if (barrage.moveX === 0) {
          // 不动的弹幕
          barrage.actualX -= top.speed;
        } else {
          barrage.actualX = barrage.x;
        }
        // 移出屏幕
        if (barrage.actualX < -1 * barrage.width) {
          // 下面这行给speed为0的弹幕
          barrage.x = barrage.actualX;
          // 该弹幕不运动
          barrage.disabled = true;
        }
        // 根据新位置绘制圆圈圈
        barrage.draw();
      }
    }
  };
  
  // 画布渲染
  const render = function () {
    // 更新已经播放时间
    time = video.currentTime;
    // 清除画布
    context.clearRect(0, 0, canvas.width, canvas.height);
    
    // 绘制画布
    draw();
    
    // 继续渲染
    if (isPause === false) {
      requestAnimationFrame(render);
    }
  };
  
  // 视频处理
  video.addEventListener('play', function () {
    isPause = false;
    render();
  });
  video.addEventListener('pause', function () {
    isPause = true;
  });
  video.addEventListener('seeked', function () {
    // 跳转播放需要清屏
    top.reset();
  });
  
  
  // 添加数据的方法
  this.add = function (obj) {
    store[Object.keys(store).length] = new Barrage(obj);
  };
  
  // 重置
  this.reset = function() {
    time = video.currentTime;
    // 画布清除
    context.clearRect(0, 0, canvas.width, canvas.height);
    
    for (let index in store) {
      const barrage = store[index];
      if (barrage) {
        // 状态变化
        barrage.disabled = false;
        // 根据时间判断哪些可以走起
        if (time < barrage.time) {
          // 视频时间小于播放时间
          // barrage.disabled = true;
          barrage.inited = null;
        } else {
          // 视频时间大于播放时间
          barrage.disabled = true;
        }
      }
    }
  };
};

// 初始化弹幕方法
/*const eleCanvas = document.getElementById('canvasBarrage');
const eleVideo = document.getElementById('videoBarrage');

const demoBarrage = new CanvasBarrage(eleCanvas, eleVideo, {
  data: dataBarrage
});*/

// 新增弹幕
/*
demoBarrage.add({
    value: '弹幕内容',
    time: eleVideo.currentTime
    // 其它如color, fontSize, opacity等可选
});
*/

// 全局设置修改，直接（例如）：
// demoBarrage.opacity = 50;
// 或者字号大小
// demoBarrage.fontSize = 16;

// 弹幕数据
/* const dataBarrage = [{
  value: 'speed设为0为非滚动',
  time: 1, // 单位秒
  speed: 0
}, {
  value: 'time控制弹幕时间，单位秒',
  color: 'blue',
  time: 2
}, ...];*/