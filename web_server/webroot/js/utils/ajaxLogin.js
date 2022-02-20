/* created at 2018/4/9 by BlueSky @cilicili */
const ajaxLogin = {
  login({username, password}) {
    let json = {};
    $.post(
      API_SERVER_padEnd("login"), {
        username, password
      }, response => {
        json = response;
      });
    return json;
  }, logout() {
    let json = {};
    $.post(
      API_SERVER_padEnd("logout"), {
        token: utils.getCookie("token")
      }, response => {
        json = response;
      });
    return json;
  }, now() {
    let json = {};
    $.post(
      API_SERVER_padEnd("now"), {
        token: utils.getCookie("token")
      }, response => {
        json = response;
      });
    return json;
  }, apply(ussage) {
    let json = {};
    $.post(
      API_SERVER_padEnd("apply"), {
        ussage, token: utils.getCookie("token")
      }, response => {
        json = response;
      });
    return json;
  }
};