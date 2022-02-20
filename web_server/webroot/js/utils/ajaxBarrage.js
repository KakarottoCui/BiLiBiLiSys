/* created at 2018/4/9 by BlueSky @cilicili */
const ajaxBarrage = {
  findId(id) {
    let json = {};
    $.get(
      API_SERVER_padEnd("barrage/findId"), {
        id
      }, response => {
        json = response;
      });
    return json;
  }, add({content, videoId, color, offtime, position}) {
    let json = {};
    $.post(
      API_SERVER_padEnd("barrage/add"), {
        content, videoId, color, offtime, position, token: utils.getCookie("token")
      }, response => {
        json = response;
      });
    return json;
  }
};