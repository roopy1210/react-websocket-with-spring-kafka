/*
 * install
 * nap install react-stomp
 * npm install sockjs-client --save
 * npm install socket.io
 */
import React, { useState, useEffect } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";

// connection 설정
const sockJS = new SockJS('http://localhost:9001/delivery');
const stompClient = Stomp.over(sockJS);

const DashBoard = (props) => {
    const [ deliveryList, setDeliveryList ] = useState(props.items);

    useEffect(() => {
        connect();
    });

    // When connection is ok then subscribe Delivery status otherwise error message print
    const connect = () => {
        stompClient.connect({}, onConnected, onError);
    }

    // When socket connection connect
    const onConnected = () => {
        stompClient.subscribe('/topic/delivery', (payload) => {
            const newDelivery = JSON.parse(payload.body);
            
            // Change delivery status of response data
            const newDeliveryList = deliveryList.map((item) => {
                if (item.id === newDelivery.id) {
                    if (newDelivery.status === 'PENDING') {
                        item.status = '배송전';
                    } else if (newDelivery.status === 'DELIVERING') {
                        item.status = '배송중';
                    } else {
                        item.status = '배송완료';
                    }
                    item.statusColor = newDelivery.statusColor.toLowerCase();
                }
                
                
                return item;
            })
           
            setDeliveryList(newDeliveryList);
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
                    {deliveryList.map((delivery) => (
                        <li key={delivery.id} className="flex items-center justify-between px-2 py-3 border-b">
                            <div>                            
                                <p className="mt-1 text-md font-bold text-indigo-900">{delivery.id.toUpperCase()}({delivery.name})</p>
                            </div>
                            <div>
                                <button className={`w-36 py-3 px-3 text-sm focus:outline-none leading-none text-${delivery.statusColor}-700 bg-${delivery.statusColor}-100 rounded`}>{delivery.status}</button>
                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </div>  
        
    );
}

export default DashBoard;