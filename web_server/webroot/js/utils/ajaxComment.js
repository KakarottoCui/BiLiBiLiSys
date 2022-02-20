/* created at 2018/4/9 by BlueSky @cilicili */
const ajaxComment = {
  findId({id, offset}) {
    let json = {};
    $.get(
      API_SERVER_padEnd("comment/findId"), {
        id, offset
      }, response => {
        json = response;
      });
    return json;
  }, add({content, videoId}) {
    let json = {};
    $.post(
      API_SERVER_padEnd("comment/add"), {
        content, videoId, token: utils.getCookie("token")
      }, response => {
        json = response;
      });
    return json;
  }, delete(id) {
    let json = {};
    $.post(
      API_SERVER_padEnd("comment/delete"), {
        id, token: utils.getCookie("token")
      }, response => {
        json = response;
      });
    return json;
  }, like(id) {
    let json = {};
    $.post(
      API_SERVER_padEnd("comment/like"), {
        id
      }, response => {
        json = response;
      });
    return json;
  }
};