import request from '@/utils/request'

export function loginByUsername(username, password) {
  const data = {
    username,
    password
  }
  return request({
    url: '${loginURI}',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '${logoutURI}',
    method: 'post'
  })
}

export function getUserInfo(token) {
  return request({
    url: '${userinfoURI}',
    method: 'get',
    params: { token }
  })
}