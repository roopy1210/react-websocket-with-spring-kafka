/*
 * install
 * nap install react-stomp
 * npm install sockjs-client --save
 * npm install socket.io
 */
import React, { useEffect } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";

// connection 설정
const sockJS = new SockJS('http://localhost:9001/delivery');
const stompClient = Stomp.over(sockJS);

const DashBoard= () => {
    useEffect(() => {
        connect();

        return () => {
            stompClient.disconnect();
        }
    });

    // When connection is ok then subscribe Delivery status otherwise error message print
    const connect = () => {
        stompClient.connect({}, onConnected, onError);
    }

    // When socket connection connect
    const onConnected = () => {
        stompClient.subscribe('/topic/delivery', function(payload) {
            const obj = JSON.parse(payload.body);
            console.log(`차량번호 : ${obj.carNo}, 배송상태 : ${obj.deliveryStatus}`);
        });
    }

    // when socket connection disconnect
    const onError = () => {
        console.log('>>> DISCONNECT');
    }

    return (
        <div className="h-100 w-full flex items-center justify-center">
            <div className="p-4 m-4 w-full lg:w-3/4 lg:max-w-3xl">
                <div>
                    <h1 className="inline-block text-2xl sm:text-3xl font-extrabold text-slate-900 tracking-tight dark:text-slate-200">
                        길동이 족발 배송현황
                    </h1>
                </div>
                <ul className="list-none mt-3">
                    <li className="flex items-center justify-between px-2 py-3 border-b">
                        <div>                            
                            <p className="mt-1 text-md font-bold text-indigo-900">라이더1(김길동)</p>
                        </div>
                        <div>
                            <button className="w-36 py-3 px-3 text-sm focus:outline-none leading-none text-gray-700 bg-gray-100 rounded">배송전</button>
                        </div>
                    </li>
                    <li className="flex items-center justify-between px-2 py-3 border-b">
                        <div>
                        <p className="mt-1 text-md font-bold text-indigo-900">라이더2(홍길동)</p>
                        </div>
                        <div>
                            <button className="w-36 py-3 px-3 text-sm focus:outline-none leading-none text-rose-700 bg-rose-100 rounded">배송중</button>
                        </div>
                    </li>
                    <li className="flex items-center justify-between px-2 py-3 border-b">
                        <div>
                        <p className="mt-1 text-md font-bold text-indigo-900">라이더3(고길동)</p>
                        </div>
                        <div>
                            <button className="w-36 py-3 px-3 text-sm focus:outline-none leading-none text-green-700 bg-green-100 rounded">배송완료</button>
                        </div>
                    </li>
                </ul>
            </div>
        </div>  
        
    );
}

export default DashBoard;