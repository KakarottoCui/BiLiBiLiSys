/* created at 2018/4/10 by BlueSky @cilicili */

const LOGIN_STATUS = ajaxLogin.now();

const UPDATE_LOGIN_STATUS = () => {
  let login_status = ajaxLogin.now();
  LOGIN_STATUS.status = login_status.status;
  LOGIN_STATUS.user = login_status.user;
};

// if (LOGIN_STATUS.status === false && utils.getPage() !== 'index' && utils.getPage() !== 'login') {
//   window.location = 'index.htm';
// }

const VIDEO_INFO = ((id) => {
  if (id === null) {
    return {
      status: "failure"
    };
  } else {
    const video = ajaxVideo.findId(id);
    if (video.status === 'success') {
      video.video.uploadTime = utils.calcTime(video.video.uploadTime.dateTime);
    }
    return video;
  }
})(utils.getRequest("id"));