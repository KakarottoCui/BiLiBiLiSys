/* created at 2018/4/9 by BlueSky @cilicili */
const utils = {
  getPage() {
    return window.location.pathname.replace(/[\/|.htm+]/g, '') || "index";
  }, getRequest(request) {
    let reg = new RegExp("(^|&)" + request + "=([^&]*)(&|$)", "i");
    let result = window.location.search.substr(1).match(reg);
    if (result != null) return decodeURI(result[2]);
    return null;
  }, getCookie(name) {
    name = name + '=';
    let cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      let cookie = cookies[i].trim();
      if (cookie.indexOf(name) === 0)
        return cookie.substring(name.length, cookie.length);
    }
    return '';
  }, setCookie(name, value) {
    document.cookie = name + '=' + value + ';'
  }, calcTime(localdatetime) {
    const {date, time} = localdatetime;
    const year = date.year;
    const month = `00${date.month}`.substr(-2);
    const day = `00${date.day}`.substr(-2);
    const hour = `00${time.hour}`.substr(-2);
    const minute = `00${time.minute}`.substr(-2);
    const second = `00${time.second}`.substr(-2);
    return new Date(`${year}/${month}/${day} ${hour}:${minute}:${second}`);
  }
};