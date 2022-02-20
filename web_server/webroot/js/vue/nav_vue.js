/* created at 2018/4/10 by BlueSky @cilicili */
const nav_vue = new Vue({
  el: '#nav_vue'
  , data: {
    login: LOGIN_STATUS.status === true
    , user: LOGIN_STATUS.user
    , page: utils.getPage()
    , videoFound: VIDEO_INFO.status === "success"
    , video: VIDEO_INFO.video
    , q: utils.getRequest('q')
  }
  , methods: {
    logout() {
      window.location = 'logout.htm';
    }, search() {
      window.location = `search.htm?q=${this.q || ''}`;
    }
  }
  , template:
    `<div class="container">
      <div class="row clearfix">
        <div class="col-md-12">
          <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.htm">cilicili 视频</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li :class="{active: page==='index'}">
                  <a href="index.htm">主页</a>
                </li>
                <li v-if="videoFound" :class="{active: page==='video'}">
                  <a :href="'video.htm?id=' + video.id">{{video.title}}</a>
                </li>
              </ul>
              <div class="navbar-form navbar-left">
                <div class="form-group">
                  <input v-model="q" type="text" class="form-control" placeholder="搜索视频" @keyup.enter="search">
                </div>
                <button class="btn btn-primary" @click="search">搜索</button>
              </div>
              <ul class="nav navbar-nav navbar-right">
                <template v-if="login">
                  <li :class="{active: page==='upload'}">
                    <a href="upload.htm">上传视频</a>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      {{user.username}} <strong class="caret"></strong>
                    </a>
                    <ul class="dropdown-menu">
                      <li>
                        <a href="settings.htm">个人设置</a>
                      </li>
                      <li class="divider"></li>
                      <li>
                        <a href="#" @click="logout">退出</a>
                      </li>
                    </ul>
                  </li>
                </template>
                <template v-else>
                  <li>
                    <a href="signup.htm">注册</a>
                  </li>
                  <li>
                    <a href="login.htm">登录</a>
                  </li>
                </template>
              </ul>
            </div>
          </nav>
        </div>
      </div>
  </div>`
});
