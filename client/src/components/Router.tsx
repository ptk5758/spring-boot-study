import React from 'react';
import { createBrowserRouter } from 'react-router-dom';
interface Page
{
  path : string; //경로
  element : React.ReactNode; // 엘리멘트
  isLogin : boolean; // 로그인 여부
}
function test() : string {
  return "asdf";
}
const pageList :Page[] = [
  {
    path : "/",
    element : <div>홈</div>,
    isLogin : false,
  },
  {
    path : "/book",
    element : <div>책</div>,
    isLogin : false,
  },
  {
    path : "/admin",
    element : <div>관리자 페이지</div>,
    isLogin : true,
  },
  {
    path : "/userinfo",
    element : <div>마이페이지</div>,
    isLogin : true,
  },
]
function LoginComponent(prop : {element : React.ReactNode}) { // 로그인안되어있으면 빠구처리를 위한 모듈
  return(
    <div>
      대충 로그인 했는지 안했는지 코드
      {prop.element}
    </div>
  ) 
  
}
export const router = createBrowserRouter(pageList.map((page : Page)=>{
  if (page.isLogin) {
    return {
      path : page.path,
      element : <LoginComponent element={page.element}/>,
    }
  } else {
    return {
      path : page.path,
      element : page.element,
    }
  }
}));